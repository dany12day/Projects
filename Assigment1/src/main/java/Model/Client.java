package Model;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class Client {
    private Long id;
    private String name;
    private String identityCardNumber;
    private String personalNumericCode;
    private String address;
    private String accountIdentificationNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getPersonalNumericCode() {
        return personalNumericCode;
    }

    public void setPersonalNumericCode(String personalNumericCode) {
        this.personalNumericCode = personalNumericCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountIdentificationNumber() {
        return accountIdentificationNumber;
    }

    public void setAccountIdentificationNumber(String accountIdentificationNumber) {
        this.accountIdentificationNumber = accountIdentificationNumber;
    }
}
