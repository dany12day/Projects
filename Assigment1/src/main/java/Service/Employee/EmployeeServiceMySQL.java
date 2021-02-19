package Service.Employee;

import Model.Account;
import Model.Builder.AccountBuilder;
import Model.Builder.ClientBuilder;
import Model.Client;
import Model.Validation.Notification;
import OtherConstants.Constants;
import Repository.Employee.EmployeeRepository;
import Repository.User.UserRepository;
import Service.UsefullFunctions.Validators.ClientAccountValidator;
import Service.UsefullFunctions.Validators.ClientValidator;

import java.time.LocalDate;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class EmployeeServiceMySQL implements  EmployeeService {

    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    public EmployeeServiceMySQL(UserRepository userRepository, EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Notification<Boolean> addClient(String name, String accountIdentificationNumber, String address, String identityCardNumber, String personalNumericCode) {
        Client client = new ClientBuilder().setName(name)
                                           .setAccountIdentificationNumber(accountIdentificationNumber)
                                           .setAddres(address).setIdentityCardNumber(identityCardNumber)
                                           .setPersonalNumericCode(personalNumericCode).build();
        ClientValidator clientValidator = new ClientValidator(client);
        boolean clientValid = clientValidator.validate();
        Notification<Boolean> addClient = new Notification<>();
        LocalDate date = LocalDate.now();
        if (!clientValid) {
            clientValidator.getErrors().forEach(addClient::addError);
            addClient.setResult(Boolean.FALSE);
        } else {
            addClient = employeeRepository.addClient(name, accountIdentificationNumber, address, identityCardNumber, personalNumericCode);
            if(!addClient.hasErrors()) {
                String activity = "Added the client "+name+" with the personal numeric code: "+personalNumericCode;
                addClient = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);
            }
        }
        return addClient;
    }

    @Override
    public Notification<Boolean> addClientAccount(String accountIdentificationNumber, String type, String money, LocalDate date) {
        Long moneyL = Long.parseLong(money);
        System.out.println(moneyL +" = "+ money);
        Account account = new AccountBuilder().setMoney(moneyL).setType(type).build();
        ClientAccountValidator accountValidator = new ClientAccountValidator(account);
        boolean accountValid = accountValidator.validate();
        Notification<Boolean> addClientAccount = new Notification<>();
        Notification<Long> addClientAccountId = new Notification<>();
        addClientAccount = employeeRepository.existsClient(accountIdentificationNumber);
        if(addClientAccount.hasErrors()){
            return addClientAccount;
        }
        addClientAccount = employeeRepository.existsAccount(accountIdentificationNumber,type);
        if(addClientAccount.hasErrors()){
            return addClientAccount;
        }
        if (!accountValid) {
            accountValidator.getErrors().forEach(addClientAccount::addError);
            addClientAccount.setResult(Boolean.FALSE);
        } else {
            addClientAccount= employeeRepository.addClientAccount(accountIdentificationNumber,type,moneyL,date);
            if (!addClientAccount.hasErrors()) {
                if(!addClientAccountId.hasErrors()) {
                    String activity = "Made an account with the identification number "+accountIdentificationNumber;
                    addClientAccount = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);
                }
            }
        }
        return addClientAccount;
    }

    @Override
    public Notification<Boolean> deleteClientAccount(String accountIdentificationNumber, String type) {
        Notification<Boolean> deleteClientAccount = new Notification<>();
        LocalDate date = LocalDate.now();
        deleteClientAccount= employeeRepository.deleteClientAccount(accountIdentificationNumber,type);
        if (!deleteClientAccount.hasErrors()) {
            String activity = "Deleted the account with the account identification number  " + accountIdentificationNumber +" and the type: "+type;
            deleteClientAccount = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);

        }
        return deleteClientAccount;
    }

    @Override
    public Notification<Boolean> deleteClient(String personalNumericCode) {
        Notification<Boolean> deleteClient = new Notification<>();
        LocalDate date = LocalDate.now();
        deleteClient= employeeRepository.deleteClientAccounts(personalNumericCode);
        if (!deleteClient.hasErrors()) {
            deleteClient = employeeRepository.deleteClient(personalNumericCode);
            if (!deleteClient.hasErrors()) {
                String activity = "Deleted the client with the account personal numeric number  " + personalNumericCode;
                deleteClient = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);
            }
        }
        return deleteClient;
    }

    @Override
    public Notification<Boolean> pay(String accountIdentificationNumber, String type, String money, String target) {
        Notification<Boolean> pay = new Notification<>();
        LocalDate date = LocalDate.now();
        pay= employeeRepository.pay(accountIdentificationNumber,type, Long.valueOf(money),target);
        if (!pay.hasErrors()) {
            String activity = "Helped client with the account identification number  " + accountIdentificationNumber +"and the type: "+type+ " pay the sum: " +money+" to "+target;
            pay = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);
        }
        return pay;
    }

    @Override
    public Notification<String> readClientAccount(String accountIdentificationNumber, String type) {
        LocalDate date = LocalDate.now();
        Notification<String> readClientAccount = new Notification<>();
        readClientAccount= employeeRepository.readClientAccount(accountIdentificationNumber,type);
        if (!readClientAccount.hasErrors()) {
            String activity = "Read client account data with the account identification number  " + accountIdentificationNumber +"and the type: "+type;
            employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);
        }
        return readClientAccount;
    }

    @Override
    public Notification<String> readClient(String personalNumericCode) {
        Notification<String> readClient = new Notification<>();
        LocalDate date = LocalDate.now();
        readClient= employeeRepository.readClient(personalNumericCode);
        if (!readClient.hasErrors()) {
            String activity = "Read client data with the personal numeric code" + personalNumericCode;
            employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);

        }
        return readClient;
    }

    @Override
    public Notification<Boolean> transfer(String accountIdentificationNumber, String type, String money, String tragetAccountIdentificationNumber, String targetAccountType) {
        Notification<Boolean> transfer = new Notification<>();
        LocalDate date = LocalDate.now();
        transfer= employeeRepository.transfer(accountIdentificationNumber,type, Long.valueOf(money),tragetAccountIdentificationNumber,targetAccountType);
        if (!transfer.hasErrors()) {
            String activity = "Transferred money from "+accountIdentificationNumber+ "to "+tragetAccountIdentificationNumber;
            transfer = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);
        }
        return transfer;
    }

    @Override
    public Notification<Boolean> changeAccountIdentificationNumber(String selectAccountIdentificationNumber, String selectType, String accountIdentificationNumber) {
        Notification<Boolean> changeAccountIdentificationNumber = new Notification<>();
        LocalDate date = LocalDate.now();
        changeAccountIdentificationNumber= employeeRepository.changeAccountIdentificationNumber(selectAccountIdentificationNumber,selectType,accountIdentificationNumber);
            if (!changeAccountIdentificationNumber.hasErrors()) {
                String activity = "changeAccountIdentificationNumber from " + selectAccountIdentificationNumber + " to "+ accountIdentificationNumber;
                changeAccountIdentificationNumber = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);
            }
            return changeAccountIdentificationNumber;
    }

    @Override
    public Notification<Boolean> changeAccountDate(String selectAccountIdentificationNumber, String selectType, String date) {
        Notification<Boolean> changeAccountDate = new Notification<>();
        LocalDate dateTemp = LocalDate.now();
        changeAccountDate= employeeRepository.changeAccountDate(selectAccountIdentificationNumber,selectType,date);
            if (!changeAccountDate.hasErrors()) {
                String activity = "Change the date of creation account identification number";
                changeAccountDate = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, dateTemp);
            }
            return changeAccountDate;
    }

    @Override
    public Notification<Boolean> changeAccountMoney(String selectAccountIdentificationNumber, String selectType, String money) {
        Notification<Boolean> changeAccountMoney = new Notification<>();
        LocalDate date = LocalDate.now();
        changeAccountMoney= employeeRepository.changeAccountMoney(selectAccountIdentificationNumber,selectType,money);
            if (!changeAccountMoney.hasErrors()) {
                String activity = "Changed the amount of money to: "+money+" for the client: "+ selectAccountIdentificationNumber+selectType;
                changeAccountMoney = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);
            }
            return changeAccountMoney;
    }

    @Override
    public Notification<Boolean> changeAccountType(String selectAccountIdentificationNumber, String selectType, String type) {
        Notification<Boolean> changeAccountType = new Notification<>();
        LocalDate date = LocalDate.now();
        changeAccountType= employeeRepository.changeAccountType(selectAccountIdentificationNumber,selectType,type);
            if (!changeAccountType.hasErrors()) {
                String activity = "Changed account type to: "+type+ " for: "+selectAccountIdentificationNumber;
                changeAccountType = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);
            }
            return changeAccountType;
    }

    @Override
    public Notification<Boolean> changeClientAccountIdentificationNumber(String selectPersonalNumericCode, String clientIdentificationNumber) {
        Notification<Boolean> changeClientAccountIdentificationNumber = new Notification<>();
        LocalDate date = LocalDate.now();
        changeClientAccountIdentificationNumber= employeeRepository.changeClientAccountIdentificationNumber(selectPersonalNumericCode,clientIdentificationNumber);
            if (!changeClientAccountIdentificationNumber.hasErrors()) {
                String activity = "Changed the client account identification number to: "+clientIdentificationNumber+" for: "+selectPersonalNumericCode;
                changeClientAccountIdentificationNumber = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);
            }
            return changeClientAccountIdentificationNumber;
    }

    @Override
    public Notification<Boolean> changeClientAddress(String selectPersonalNumericCode, String address) {
        Notification<Boolean> changeClientAddress = new Notification<>();
        LocalDate date = LocalDate.now();
        changeClientAddress= employeeRepository.changeClientAddress(selectPersonalNumericCode,address);
            if (!changeClientAddress.hasErrors()) {
                String activity = "Changed the client address to: "+address+" for: "+selectPersonalNumericCode;
                changeClientAddress = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);
            }
            return changeClientAddress;
    }

    @Override
    public Notification<Boolean> changeClientIdentityCardNumber(String selectPersonalNumericCode, String identityCardNumber) {
        Notification<Boolean> changeClientIdentityCardNumber = new Notification<>();
        LocalDate date = LocalDate.now();
        changeClientIdentityCardNumber= employeeRepository.changeClientIdentityCardNumber(selectPersonalNumericCode,identityCardNumber);
            if (!changeClientIdentityCardNumber.hasErrors()) {
                String activity = "Changed the client identity card number to: "+identityCardNumber+" for: "+selectPersonalNumericCode;
                changeClientIdentityCardNumber = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);
            }
            return changeClientIdentityCardNumber;
    }

    @Override
    public Notification<Boolean> changeClientName(String selectPersonalNumericCode, String name) {
        Notification<Boolean> changeClientName = new Notification<>();
        LocalDate date = LocalDate.now();
        changeClientName= employeeRepository.changeClientName(selectPersonalNumericCode,name);
            if (!changeClientName.hasErrors()) {
                String activity = "Changed the client name: "+name+" for: "+selectPersonalNumericCode;
                changeClientName = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);
            }
            return changeClientName;
    }

    @Override
    public Notification<Boolean> changeClientPersonalNumericCode(String selectPersonalNumericCode, String personalNumericCode) {
        Notification<Boolean> changeClientPersonalNumericCode = new Notification<>();
        LocalDate date = LocalDate.now();
        changeClientPersonalNumericCode= employeeRepository.changeClientPersonalNumericCode(selectPersonalNumericCode,personalNumericCode);
            if (!changeClientPersonalNumericCode.hasErrors()) {
                String activity = "Changed the client personal numeric code: "+personalNumericCode+" for: "+selectPersonalNumericCode;
                changeClientPersonalNumericCode = employeeRepository.addEmployeeActivity(Constants.CurrentEmployee.getCurrentEmployee(), activity, date);
            }
            return changeClientPersonalNumericCode;
    }
}
