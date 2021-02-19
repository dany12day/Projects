package Service.UsefullFunctions.Validators;

import Model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class EmployeeValidator {
    private static final String NAME_VALIDATION_REGEX = "^[a-zA-Z ]+$";

    public List<String> getErrors() {
        return errors;
    }

    private final List<String> errors;

    private final Employee employee;

    public EmployeeValidator(Employee employee) {
        this.employee = employee;
        errors = new ArrayList<>();
    }

    public boolean validate() {
        validateName(employee.getName());

        return errors.isEmpty();
    }

    private void validateName(String username) {
        if (!Pattern.compile(NAME_VALIDATION_REGEX).matcher(username).matches()) {
            errors.add("Invalid name!");
        }
    }


}
