package Repository.Employee;

import Model.Builder.ClientBuilder;
import Model.Client;
import Model.Validation.Notification;
import java.sql.*;
import java.time.LocalDate;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class EmployeeRepositoryMySQL implements  EmployeeRepository{
    private final Connection connection;

    public EmployeeRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Notification<Boolean> addClient(String name, String accountIdentificationNumber, String address, String identityCardNumber, String personalNumericCode) {
        Notification<Boolean> addClient = new Notification<>();
        try {
            PreparedStatement insertClientStatement = connection
                    .prepareStatement("INSERT INTO client values (null, ? , ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            insertClientStatement.setString(1, name);
            insertClientStatement.setString(2, identityCardNumber);
            insertClientStatement.setString(3, personalNumericCode);
            insertClientStatement.setString(4, address);
            insertClientStatement.setString(5, accountIdentificationNumber);
            insertClientStatement.executeUpdate();
            ResultSet rs = insertClientStatement.getGeneratedKeys();
            rs.next();
            addClient.setResult(true);
        } catch (SQLException e) {
            addClient.setResult(false);
            addClient.addError("Client can not be saved: identityCardNumber or accountIdentificationNumber could be already used");
        }
        return addClient;
    }

    @Override
    public Notification<Boolean> addClientAccount(String accountIdentificationNumber, String type, Long money, LocalDate date) {
        Notification<Boolean> addClientAccount = new Notification<>();
        try {
            PreparedStatement insertAccountStatement = connection
                    .prepareStatement("INSERT INTO account values (null, ? , ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            insertAccountStatement.setString(1, accountIdentificationNumber);
            insertAccountStatement.setString(2, type);
            insertAccountStatement.setLong(3, money);
            insertAccountStatement.setDate(4, Date.valueOf(date));
            insertAccountStatement.executeUpdate();
            ResultSet rs = insertAccountStatement.getGeneratedKeys();
            rs.next();
            addClientAccount.setResult(true);
        } catch (SQLException e) {
            addClientAccount.setResult(false);
            addClientAccount.addError("Client account can not be saved");
        }
        return addClientAccount;
    }

    @Override
    public Notification<Boolean> deleteClientAccount(String accountIdentificationNumber, String type) {
        Notification<Boolean> deleteClientAccount = new Notification<>();
        try {
            PreparedStatement deleteAccountStatement = connection
                    .prepareStatement("DELETE FROM account where accountIdentificationNumber=? and typeAccount = ? ", Statement.RETURN_GENERATED_KEYS);
            deleteAccountStatement.setString(1, accountIdentificationNumber);
            deleteAccountStatement.setString(2, type);
            deleteAccountStatement.executeUpdate();
            ResultSet rs = deleteAccountStatement.getGeneratedKeys();
            rs.next();
            deleteClientAccount.setResult(true);
        } catch (SQLException e) {
            e.printStackTrace();
            deleteClientAccount.setResult(false);
            deleteClientAccount.addError("Can not delete client account");
        }
        return deleteClientAccount;
    }

    @Override
    public Notification<Boolean> deleteClient(String personalNumericCode) {
        Notification<Boolean> deleteClient = new Notification<>();
        try {
            PreparedStatement deleteClientStatement = connection
                    .prepareStatement("DELETE FROM client where personalNumericCode=? ", Statement.RETURN_GENERATED_KEYS);
            deleteClientStatement.setString(1, personalNumericCode);
            deleteClientStatement.executeUpdate();
            ResultSet rs = deleteClientStatement.getGeneratedKeys();
            rs.next();
            deleteClient.setResult(true);
        } catch (SQLException e) {
            e.printStackTrace();
            deleteClient.setResult(false);
            deleteClient.addError("Can not delete client");
        }
        return deleteClient;
    }

    @Override
    public Notification<Boolean> pay(String accountIdentificationNumber, String type, Long money, String pay) {
        Long newSum = Long.valueOf(0);
        Notification<Boolean> verifyClient = new Notification<>();
        try {
            PreparedStatement selectAccountStatement = connection
                    .prepareStatement("select * FROM  account where accountIdentificationNumber = ? and typeAccount = ?", Statement.RETURN_GENERATED_KEYS);
            selectAccountStatement.setString(1, accountIdentificationNumber);
            selectAccountStatement.setString(2, type);
            ResultSet rs = selectAccountStatement.executeQuery();
            rs.next();
            newSum= rs.getLong("money");
            verifyClient.setResult(true);
        } catch (SQLException e) {
            verifyClient.setResult(false);
            verifyClient.addError("Account dose not exists");
        }
        if(verifyClient.hasErrors()) {
            return verifyClient;
        }
        newSum= newSum-money;
        Notification<Boolean> payN = new Notification<>();
        try {
            PreparedStatement updateAccountStatement = connection
                    .prepareStatement("UPDATE account SET money = ? where accountIdentificationNumber = ? and typeAccount = ?", Statement.RETURN_GENERATED_KEYS);
            updateAccountStatement.setLong(1, newSum);
            updateAccountStatement.setString(2, accountIdentificationNumber);
            updateAccountStatement.setString(3, type);
            updateAccountStatement.executeUpdate();
            ResultSet rs = updateAccountStatement.getGeneratedKeys();
            rs.next();
            payN.setResult(true);
        } catch (SQLException e) {
            payN.setResult(false);
            payN.addError("Can not pay the bill");
        }
        return payN;
    }

    @Override
    public Notification<String> readClientAccount(String accountIdentificationNumber, String type) {
        Notification<String> readClientAccount = new Notification<>();
        try {
            PreparedStatement selectAccountStatement = connection
                    .prepareStatement("select * FROM  account where accountIdentificationNumber = ? and typeAccount = ?", Statement.RETURN_GENERATED_KEYS);
            selectAccountStatement.setString(1, accountIdentificationNumber);
            selectAccountStatement.setString(2, type);
            ResultSet rs = selectAccountStatement.executeQuery();
            rs.next();
            readClientAccount.setResult("Account identification number: "+rs.getString("accountIdentificationNumber") +" type: "+ rs.getString("typeAccount") +" sum of money: "+ rs.getLong("money") +" date of creation: "+ rs.getDate("date"));
        } catch (SQLException e) {
            readClientAccount.addError("Account dose not exists");
        }
        return readClientAccount;
    }

    @Override
    public Notification<String> readClient(String personalNumericCode) {
        Notification<String> readClient = new Notification<>();
        try {
            PreparedStatement selectClientStatement = connection
                    .prepareStatement("select * FROM client where personalNumericCode = ?", Statement.RETURN_GENERATED_KEYS);
            selectClientStatement.setString(1, personalNumericCode);
            selectClientStatement.executeQuery();
            ResultSet rs = selectClientStatement.executeQuery();
            rs.next();
            readClient.setResult("Name: "+rs.getString("name")+" Identity card number: "+rs.getString("identityCardNumber") +" Personal numeric Code: "+ rs.getString("personalNumericCode") +" Address: "+ rs.getString("address") +" account identification number: "+  rs.getString("accountIdentificationNumber"));
        } catch (SQLException e) {
            readClient.addError("Client dose not exists");
        }
        return readClient;
    }

    @Override
    public Notification<Boolean> transfer(String accountIdentificationNumber, String type, Long money, String tragetAccountIdentificationNumber, String targetAccountType) {
        Long newSum1 = Long.valueOf(0);
        Long newSum2 = Long.valueOf(0);
        Notification<Boolean> transfer = new Notification<>();
        try {
            PreparedStatement selectAccountStatement = connection
                    .prepareStatement("select * FROM  account where accountIdentificationNumber = ? and typeAccount = ?", Statement.RETURN_GENERATED_KEYS);
            selectAccountStatement.setString(1, accountIdentificationNumber);
            selectAccountStatement.setString(2, type);
            ResultSet rs = selectAccountStatement.executeQuery();
            rs.next();
            newSum1= rs.getLong("money");
            transfer.setResult(true);
        } catch (SQLException e) {
            transfer.setResult(false);
            transfer.addError("Account sender dose not exists");
        }
        if(transfer.hasErrors()) {
            return transfer;
        }
        newSum1= newSum1-money;
        transfer = new Notification<>();
        try {
            PreparedStatement selectAccountStatement = connection
                    .prepareStatement("select * FROM  account where accountIdentificationNumber = ? and typeAccount = ?", Statement.RETURN_GENERATED_KEYS);
            selectAccountStatement.setString(1, tragetAccountIdentificationNumber);
            selectAccountStatement.setString(2, targetAccountType);
            ResultSet rs = selectAccountStatement.executeQuery();
            rs.next();
            newSum2= rs.getLong("money");
            transfer.setResult(true);
        } catch (SQLException e) {
            transfer.setResult(false);
            transfer.addError("Account target dose not exists");
        }
        if(transfer.hasErrors()) {
            return transfer;
        }
        newSum2= newSum2+money;
        Notification<Boolean> modifyMoney = new Notification<>();
        try {
            PreparedStatement updateAccountStatement = connection
                    .prepareStatement("UPDATE account SET money = ? where accountIdentificationNumber = ? and typeAccount = ?", Statement.RETURN_GENERATED_KEYS);
            updateAccountStatement.setLong(1, newSum1);
            updateAccountStatement.setString(2, accountIdentificationNumber);
            updateAccountStatement.setString(3, type);
            updateAccountStatement.executeUpdate();
            ResultSet rs = updateAccountStatement.getGeneratedKeys();
            rs.next();
            modifyMoney.setResult(true);
        } catch (SQLException e) {
            modifyMoney.setResult(false);
            modifyMoney.addError("Can not send the money");
        }
        modifyMoney = new Notification<>();
        try {
            PreparedStatement updateAccountStatement = connection
                    .prepareStatement("UPDATE account SET money = ? where accountIdentificationNumber = ? and typeAccount = ?", Statement.RETURN_GENERATED_KEYS);
            updateAccountStatement.setLong(1, newSum2);
            updateAccountStatement.setString(2, tragetAccountIdentificationNumber);
            updateAccountStatement.setString(3, targetAccountType);
            updateAccountStatement.executeUpdate();
            ResultSet rs = updateAccountStatement.getGeneratedKeys();
            rs.next();
            modifyMoney.setResult(true);
        } catch (SQLException e) {
            modifyMoney.setResult(false);
            modifyMoney.addError("Can not receive the money");
        }
        return modifyMoney;
    }

    @Override
    public Notification<Boolean> changeAccountIdentificationNumber(String accountIdentificationNumber, String selectType, String newAccountIdentificationNumber) {
        Notification<Boolean> modifyAIN = new Notification<>();
        try {
            PreparedStatement updateAccountStatement = connection
                    .prepareStatement("UPDATE account SET accountIdentificationNumber = ? where accountIdentificationNumber = ?", Statement.RETURN_GENERATED_KEYS);
            updateAccountStatement.setString(1, newAccountIdentificationNumber);
            updateAccountStatement.setString(2, accountIdentificationNumber);
            updateAccountStatement.executeUpdate();
            ResultSet rs = updateAccountStatement.getGeneratedKeys();
            rs.next();
            modifyAIN.setResult(true);
        } catch (SQLException e) {
            modifyAIN.setResult(false);
            modifyAIN.addError("Can not change the account identification number");
        }
        if(modifyAIN.hasErrors())
            return modifyAIN;
        try {
            PreparedStatement updateClientStatement = connection
                    .prepareStatement("UPDATE client SET accountIdentificationNumber = ? where accountIdentificationNumber = ?", Statement.RETURN_GENERATED_KEYS);
            updateClientStatement.setString(1, newAccountIdentificationNumber);
            updateClientStatement.setString(2, accountIdentificationNumber);
            updateClientStatement.executeUpdate();
            ResultSet rs = updateClientStatement.getGeneratedKeys();
            rs.next();
            modifyAIN.setResult(true);
        } catch (SQLException e) {
            modifyAIN.setResult(false);
            modifyAIN.addError("Can not change the client identification number");
        }
        return modifyAIN;
    }

    @Override
    public Notification<Boolean> changeAccountDate(String selectAccountIdentificationNumber, String selectType, String date) {
        Notification<Boolean> changeAccountDate = new Notification<>();
        try {
            PreparedStatement updateAccountStatement = connection
                    .prepareStatement("UPDATE account SET date = ? where typeAccount = ? and accountIdentificationNumber = ?", Statement.RETURN_GENERATED_KEYS);
            updateAccountStatement.setString(3, selectAccountIdentificationNumber);
            updateAccountStatement.setString(2, selectType);
            updateAccountStatement.setDate(1, Date.valueOf(date));
            updateAccountStatement.executeUpdate();
            ResultSet rs = updateAccountStatement.getGeneratedKeys();
            rs.next();
            changeAccountDate.setResult(true);
        } catch (SQLException e) {
            changeAccountDate.setResult(false);
            changeAccountDate.addError("Can not change the account creation date");
        }
        return changeAccountDate;
    }

    @Override
    public Notification<Boolean> changeAccountMoney(String selectAccountIdentificationNumber, String selectType, String money) {
        Notification<Boolean> changeAccountMoney = new Notification<>();
        try {
            PreparedStatement updateAccountStatement = connection
                    .prepareStatement("UPDATE account SET money = ? where typeAccount = ? and accountIdentificationNumber = ?", Statement.RETURN_GENERATED_KEYS);
            updateAccountStatement.setString(3, selectAccountIdentificationNumber);
            updateAccountStatement.setString(2, selectType);
            updateAccountStatement.setLong(1, Long.parseLong(money));
            updateAccountStatement.executeUpdate();

            ResultSet rs = updateAccountStatement.getGeneratedKeys();
            rs.next();
            changeAccountMoney.setResult(true);
        } catch (SQLException e) {
            changeAccountMoney.setResult(false);
            changeAccountMoney.addError("Can not change the account of money");
        }
        return changeAccountMoney;
    }

    @Override
    public Notification<Boolean> changeAccountType(String selectAccountIdentificationNumber, String selectType, String type) {
        Notification<Boolean> changeAccountType = new Notification<>();
        try {
            PreparedStatement updateAccountStatement = connection
                    .prepareStatement("UPDATE account SET typeAccount = ? where typeAccount = ? and accountIdentificationNumber = ?", Statement.RETURN_GENERATED_KEYS);
            updateAccountStatement.setString(3, selectAccountIdentificationNumber);
            updateAccountStatement.setString(2, selectType);
            updateAccountStatement.setString(1, type);
            updateAccountStatement.executeUpdate();
            ResultSet rs = updateAccountStatement.getGeneratedKeys();
            rs.next();
            changeAccountType.setResult(true);
        } catch (SQLException e) {
            changeAccountType.setResult(false);
            changeAccountType.addError("Can not change the account type");
        }
        return changeAccountType;
    }

    @Override
    public Notification<Boolean> changeClientAccountIdentificationNumber(String selectPersonalNumericCode, String clientIdentificationNumber) {
        Notification<Boolean> changeClientAccountIdentificationNumber = new Notification<>();
        String ICN =null;
        try {
            PreparedStatement selectClientStatement = connection
                    .prepareStatement("select * FROM client where personalNumericCode = ?", Statement.RETURN_GENERATED_KEYS);
            selectClientStatement.setString(1, selectPersonalNumericCode);
            selectClientStatement.executeQuery();
            ResultSet rs = selectClientStatement.executeQuery();
            rs.next();
            ICN = rs.getString("accountIdentificationNumber");
            changeClientAccountIdentificationNumber.setResult(true);
        } catch (SQLException e) {
            changeClientAccountIdentificationNumber.addError("Can not find the client");
            changeClientAccountIdentificationNumber.setResult(false);
            return changeClientAccountIdentificationNumber;
        }
        changeClientAccountIdentificationNumber = new Notification<>();
        try {
            PreparedStatement updateClientStatement = connection
                    .prepareStatement("UPDATE client SET accountIdentificationNumber = ? where personalNumericCode = ?", Statement.RETURN_GENERATED_KEYS);
            updateClientStatement.setString(1, clientIdentificationNumber);
            updateClientStatement.setString(2, selectPersonalNumericCode);
            updateClientStatement.executeUpdate();
            ResultSet rs = updateClientStatement.getGeneratedKeys();
            rs.next();
            changeClientAccountIdentificationNumber.setResult(true);
        } catch (SQLException e) {
            changeClientAccountIdentificationNumber.setResult(false);
            changeClientAccountIdentificationNumber.addError("Can not change the client identification number");
            return changeClientAccountIdentificationNumber;
        }
        if(ICN!=null){
            try {
                PreparedStatement updateAccountStatement = connection
                        .prepareStatement("UPDATE account SET accountIdentificationNumber = ? where accountIdentificationNumber = ?", Statement.RETURN_GENERATED_KEYS);
                updateAccountStatement.setString(1, clientIdentificationNumber);
                updateAccountStatement.setString(2, ICN);
                updateAccountStatement.executeUpdate();
                ResultSet rs = updateAccountStatement.getGeneratedKeys();
                rs.next();
                changeClientAccountIdentificationNumber.setResult(true);
            } catch (SQLException e) {
                changeClientAccountIdentificationNumber.setResult(false);
                changeClientAccountIdentificationNumber.addError("Can not change the account identification number");
            }
        }
        return changeClientAccountIdentificationNumber;
    }

    @Override
    public Notification<Boolean> changeClientAddress(String selectPersonalNumericCode, String address) {
        Notification<Boolean> changeClientAddress = new Notification<>();
        try {
            PreparedStatement updateClientStatement = connection
                    .prepareStatement("UPDATE client SET address = ? where personalNumericCode = ?", Statement.RETURN_GENERATED_KEYS);
            updateClientStatement.setString(1, address);
            updateClientStatement.setString(2, selectPersonalNumericCode);
            updateClientStatement.executeUpdate();
            ResultSet rs = updateClientStatement.getGeneratedKeys();
            rs.next();
            changeClientAddress.setResult(true);
        } catch (SQLException e) {
            changeClientAddress.setResult(false);
            changeClientAddress.addError("Can not change the clients address");
        }
        return changeClientAddress;
    }

    @Override
    public Notification<Boolean> changeClientIdentityCardNumber(String selectPersonalNumericCode, String identityCardNumber) {
        Notification<Boolean> changeClientIdentityCardNumber = new Notification<>();
        try {
            PreparedStatement updateClientStatement = connection
                    .prepareStatement("UPDATE client SET identityCardNumber = ? where personalNumericCode = ?", Statement.RETURN_GENERATED_KEYS);
            updateClientStatement.setString(1, identityCardNumber);
            updateClientStatement.setString(2, selectPersonalNumericCode);
            updateClientStatement.executeUpdate();
            ResultSet rs = updateClientStatement.getGeneratedKeys();
            rs.next();
            changeClientIdentityCardNumber.setResult(true);
        } catch (SQLException e) {
            changeClientIdentityCardNumber.setResult(false);
            changeClientIdentityCardNumber.addError("Can not change the clients identity card number");
        }

        return changeClientIdentityCardNumber;
    }

    @Override
    public Notification<Boolean> changeClientName(String selectPersonalNumericCode, String name) {
        Notification<Boolean> changeClientName = new Notification<>();
        try {
            PreparedStatement updateClientStatement = connection
                    .prepareStatement("UPDATE client SET name = ? where personalNumericCode = ?", Statement.RETURN_GENERATED_KEYS);
            updateClientStatement.setString(1, name);
            updateClientStatement.setString(2, selectPersonalNumericCode);
            updateClientStatement.executeUpdate();
            ResultSet rs = updateClientStatement.getGeneratedKeys();
            rs.next();
            changeClientName.setResult(true);
        } catch (SQLException e) {
            changeClientName.setResult(false);
            changeClientName.addError("Can not change the clients name");
        }

        return changeClientName;
    }

    @Override
    public Notification<Boolean> changeClientPersonalNumericCode(String selectPersonalNumericCode, String personalNumericCode) {
        Notification<Boolean> changeClientPersonalNumericCode = new Notification<>();
        try {
            PreparedStatement updateClientStatement = connection
                    .prepareStatement("UPDATE client SET personalNumericCode = ? where personalNumericCode = ?", Statement.RETURN_GENERATED_KEYS);
            updateClientStatement.setString(1, personalNumericCode);
            updateClientStatement.setString(2, selectPersonalNumericCode);
            updateClientStatement.executeUpdate();
            ResultSet rs = updateClientStatement.getGeneratedKeys();
            rs.next();
            changeClientPersonalNumericCode.setResult(true);
        } catch (SQLException e) {
            changeClientPersonalNumericCode.setResult(false);
            changeClientPersonalNumericCode.addError("Can not change the client personal numeric code");
        }

        return changeClientPersonalNumericCode;
    }

    @Override
    public Notification<Boolean> addEmployeeActivity(long idEmployee, String activity, LocalDate date) {
        Notification<Boolean> addEmployeeActivity = new Notification<>();
        try {
            PreparedStatement insertEmployeeActivityStatement = connection
                    .prepareStatement("INSERT INTO employeeactivity values (null, ? , ?, ?)", Statement.RETURN_GENERATED_KEYS);
            insertEmployeeActivityStatement.setLong(1, idEmployee);
            insertEmployeeActivityStatement.setString(2, activity);
            insertEmployeeActivityStatement.setDate(3, Date.valueOf(date));
            insertEmployeeActivityStatement.executeUpdate();
            ResultSet rs = insertEmployeeActivityStatement.getGeneratedKeys();
            rs.next();
            addEmployeeActivity.setResult(true);
        } catch (SQLException e) {
            e.printStackTrace();
            addEmployeeActivity.setResult(false);
            addEmployeeActivity.addError("Client activity can not be saved");
        }
        return addEmployeeActivity;
    }

    @Override
    public Notification<Client> findClientByCNP(String personalNumericCode) {
        Notification<Client> findClientByCNP = new Notification<>();
        try {
            PreparedStatement selectClientStatement = connection
                    .prepareStatement("select * FROM client where personalNumericCode = ?", Statement.RETURN_GENERATED_KEYS);
            selectClientStatement.setString(1, personalNumericCode);
            selectClientStatement.executeQuery();
            ResultSet rs = selectClientStatement.executeQuery();
            rs.next();
            Client client  = new ClientBuilder().setPersonalNumericCode(rs.getString("personalNumericCode")).setId(rs.getLong("id")).setAddres(rs.getString("address")).setIdentityCardNumber(rs.getString("identityCardNumber")).setAccountIdentificationNumber(rs.getString("accountIdentificationNumber")).setName(rs.getString("name")).build();
            findClientByCNP.setResult(client);
        } catch (SQLException e) {
            findClientByCNP.addError("Client dose not exists");
        }
        return findClientByCNP;
    }

    @Override
    public Notification<Boolean> deleteClientAccounts(String personalNumericCode) {
        Notification<Client> deleteClientAccounts = findClientByCNP(personalNumericCode);
        Notification<Boolean> deleteAccounts = new Notification<>();
        if(deleteClientAccounts.hasErrors()) {
            deleteAccounts.setResult(false);
            deleteAccounts.addError(deleteClientAccounts.getFormattedErrors());
            return deleteAccounts;
        }
        try {
            PreparedStatement deleteAccountStatement = connection
                    .prepareStatement("DELETE FROM account where accountIdentificationNumber=?", Statement.RETURN_GENERATED_KEYS);
            deleteAccountStatement.setString(1, deleteClientAccounts.getResult().getAccountIdentificationNumber());
            deleteAccountStatement.executeUpdate();
            ResultSet rs = deleteAccountStatement.getGeneratedKeys();
            rs.next();
            deleteAccounts.setResult(true);
        } catch (SQLException e) {
            e.printStackTrace();
            deleteAccounts.setResult(false);
            deleteAccounts.addError("Can not delete client account");
        }
        if(deleteAccounts.hasErrors())
            return deleteAccounts;
        return deleteClient(personalNumericCode);
    }

    @Override
    public Notification<Boolean> existsClient(String accountIdentificationNumber) {
        Notification<Boolean> existsClient = new Notification<>();
        try {
            PreparedStatement selectClientStatement = connection
                    .prepareStatement("select * FROM client where accountIdentificationNumber = ?", Statement.RETURN_GENERATED_KEYS);
            selectClientStatement.setString(1, accountIdentificationNumber);
            selectClientStatement.executeQuery();

            ResultSet rs = selectClientStatement.executeQuery();
            rs.next();
            System.out.println(rs.getString("name"));
            existsClient.setResult(true);
        } catch (SQLException e) {
            existsClient.setResult(false);
            existsClient.addError("Client dose not exists");
        }
        return existsClient;
    }

    @Override
    public Notification<Boolean> existsAccount(String accountIdentificationNumber, String type) {
        Notification<Boolean> existsAccount = new Notification<>();
        try {
            PreparedStatement selectAccountStatement = connection
                    .prepareStatement("select * FROM  account where accountIdentificationNumber = ? and typeAccount = ?", Statement.RETURN_GENERATED_KEYS);
            selectAccountStatement.setString(1, accountIdentificationNumber);
            selectAccountStatement.setString(2, type);
            ResultSet rs = selectAccountStatement.executeQuery();
            rs.next();
            System.out.println(rs.getString("typeAccount"));
            existsAccount.setResult(false);
            existsAccount.addError("Account already exists");
        } catch (SQLException e) {
            existsAccount.setResult(true);
        }
        return existsAccount;
    }
}
