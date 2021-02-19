package Model;

import java.util.Date;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class Account {
    private Long id;
    private String accountIdentificationNumber;
    private String type;
    private Long money;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountIdentificationNumber() {
        return accountIdentificationNumber;
    }

    public void setAccountIdentificationNumber(String accountIdentificationNumber) {
        this.accountIdentificationNumber = accountIdentificationNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
