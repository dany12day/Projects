package Service.Employee;

import Model.Validation.Notification;

import java.time.LocalDate;

public interface EmployeeService {
    public Notification<Boolean>  addClient(String name, String accountIdentificationNumber, String address, String identityCardNumber, String personalNumericCode);
    public Notification<Boolean> addClientAccount(String accountIdentificationNumber, String type, String money, LocalDate date);
    public Notification<Boolean> deleteClientAccount(String accountIdentificationNumber, String type);
    public Notification<Boolean> deleteClient(String personalNumericCode);
    Notification<Boolean> pay(String accountIdentificationNumber, String type, String money, String pay);
    Notification<String> readClientAccount(String accountIdentificationNumber, String type);
    Notification<String> readClient(String personalNumericCode);
    Notification<Boolean> transfer(String accountIdentificationNumber, String type, String money, String tragetAccountIdentificationNumber, String targetAccountType);
    Notification<Boolean> changeAccountIdentificationNumber(String selectAccountIdentificationNumber, String selectType, String accountIdentificationNumber);
    Notification<Boolean> changeAccountDate(String selectAccountIdentificationNumber, String selectType, String date);
    Notification<Boolean> changeAccountMoney(String selectAccountIdentificationNumber, String selectType, String money);
    Notification<Boolean> changeAccountType(String selectAccountIdentificationNumber, String selectType, String type);
    Notification<Boolean> changeClientAccountIdentificationNumber(String selectPersonalNumericCode, String clientIdentificationNumber);
    Notification<Boolean> changeClientAddress(String selectPersonalNumericCode, String address);
    Notification<Boolean> changeClientIdentityCardNumber(String selectPersonalNumericCode, String identityCardNumber);
    Notification<Boolean> changeClientName(String selectPersonalNumericCode, String name);
    Notification<Boolean> changeClientPersonalNumericCode(String selectPersonalNumericCode, String personalNumericCode);
}
