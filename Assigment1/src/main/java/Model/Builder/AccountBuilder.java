package Model.Builder;

import Model.Account;
import java.util.Date;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class AccountBuilder {
    private Account account;

    public AccountBuilder(){
        this.account= new Account();
    }

    public AccountBuilder setId(Long id){
        this.account.setId(id);
        return this;
    }

    public AccountBuilder setAccountIdentificationNumber(String accountIdentificationNumber){
        this.account.setAccountIdentificationNumber(accountIdentificationNumber);
        return this;
    }

    public AccountBuilder setType(String type){
        this.account.setType(type);
        return this;
    }

    public AccountBuilder setMoney(Long money){
        this.account.setMoney(money);
        return this;
    }

    public AccountBuilder setDate(Date date){
        this.account.setDate(date);
        return this;
    }

    public Account build(){
        return account;
    }
}
