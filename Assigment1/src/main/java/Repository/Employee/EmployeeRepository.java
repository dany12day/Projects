package Repository.Employee;

import Model.Client;
import Model.Validation.Notification;
import java.time.LocalDate;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public interface EmployeeRepository {
    Notification<Boolean> addClient(String name, String accountIdentificationNumber, String address, String identityCardNumber, String personalNumericCode);
    Notification<Boolean> addClientAccount(String accountIdentificationNumber, String type, Long money, LocalDate date);
    Notification<Boolean> deleteClientAccount(String accountIdentificationNumber, String type);
    Notification<Boolean> deleteClient(String personalNumericCode);
    Notification<Boolean> pay(String accountIdentificationNumber, String type, Long money, String pay);
    Notification<String> readClientAccount(String accountIdentificationNumber, String type);
    Notification<String> readClient(String personalNumericCode);
    Notification<Boolean> transfer(String accountIdentificationNumber, String type, Long money, String tragetAccountIdentificationNumber, String targetAccountType);
    Notification<Boolean> changeAccountIdentificationNumber(String accountIdentificationNumber, String selectType, String newAccountIdentificationNumber);
    Notification<Boolean> changeAccountDate(String selectAccountIdentificationNumber, String selectType, String date);
    Notification<Boolean> changeAccountMoney(String selectAccountIdentificationNumber, String selectType, String money);
    Notification<Boolean> changeAccountType(String selectAccountIdentificationNumber, String selectType, String type);
    Notification<Boolean> changeClientAccountIdentificationNumber(String selectPersonalNumericCode, String clientIdentificationNumber);
    Notification<Boolean> changeClientAddress(String selectPersonalNumericCode, String address);
    Notification<Boolean> changeClientIdentityCardNumber(String selectPersonalNumericCode, String identityCardNumber);
    Notification<Boolean> changeClientName(String selectPersonalNumericCode, String name);
    Notification<Boolean> changeClientPersonalNumericCode(String selectPersonalNumericCode, String personalNumericCode);
    Notification<Boolean> addEmployeeActivity(long idEmployee, String activity, LocalDate date);
    Notification<Client> findClientByCNP(String personalNumericCode);
    Notification<Boolean> deleteClientAccounts(String personalNumericCode);
    Notification<Boolean> existsClient(String accountIdentificationNumber);
    Notification<Boolean> existsAccount(String accountIdentificationNumber, String type);
}
