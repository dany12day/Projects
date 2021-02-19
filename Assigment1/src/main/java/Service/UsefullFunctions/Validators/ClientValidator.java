package Service.UsefullFunctions.Validators;

import Model.Client;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class ClientValidator {
    private static final String NAME_VALIDATION_REGEX = "^[\\p{L} .'-]+$";
    private static final String ICN_VALIDATION_REGEX = "^[a-zA-Z0-9]+$";
    private static final int ICN_LENGTH = 6;
    private static final String CNP_VALIDATION_REGEX = "^[0-9]+$";
    private static final int CNP_LENGTH = 12;
    private static final String ADDRESS_VALIDATION_REGEX = "^[a-zA-Z0-9 _.]+$";

    public List<String> getErrors() {
        return errors;
    }

    private final List<String> errors;

    private final Client client;

    public ClientValidator(Client client) {
        this.client = client;
        errors = new ArrayList<>();
    }

    public boolean validate() {
        validateName(client.getName());
        validateICN(client.getIdentityCardNumber());
        validateCNP(client.getPersonalNumericCode());
        validateAddress(client.getAddress());
        return errors.isEmpty();
    }

    private void validateName(String username) {
        if (!Pattern.compile(NAME_VALIDATION_REGEX).matcher(username).matches()) {
            System.out.println(username);
            errors.add("Invalid name!");
        }
    }

    private void validateICN(String ICN) {
        if (!Pattern.compile(ICN_VALIDATION_REGEX).matcher(ICN).matches()) {
            System.out.println(ICN);
            errors.add("Invalid identification card number!");
        }
        if (ICN.length() != ICN_LENGTH) {
            errors.add("Identification card number need to have 6 characters!");
        }
    }

    private void validateCNP(String CNP) {
        if (CNP.length() < CNP_LENGTH) {
            errors.add("Personal numeric code need to have 12 digits!");
        }
        if (!Pattern.compile(CNP_VALIDATION_REGEX).matcher(CNP).matches()) {
            System.out.println(CNP);
            errors.add("Invalid personal number code!");
        }
    }

    private void validateAddress(String address) {
        if (!Pattern.compile(ADDRESS_VALIDATION_REGEX).matcher(address).matches()) {
            System.out.println(address);
            errors.add("Invalid address can not have special characters!");
        }
    }


}
