package Service.UsefullFunctions.Validators;

import Model.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class ClientAccountValidator {
    private static final String TYPE_VALIDATION_REGEX = "^[a-zA-Z]+$";

    public List<String> getErrors() {
        return errors;
    }

    private final List<String> errors;

    private final Account account;

    public ClientAccountValidator(Account account) {
        this.account = account;
        errors = new ArrayList<>();
    }

    public boolean validate() {

        validateType(account.getType());
        validateMoney(account.getMoney());

        return errors.isEmpty();
    }


    private void validateMoney(Long money) {
        if (money<0) {
            errors.add("Can not start an account with a negative sum!");
        }

    }

    private void validateType(String type) {
        if (!Pattern.compile(TYPE_VALIDATION_REGEX).matcher(type).matches()) {
            errors.add("Invalid type account!");
        }
    }


}
