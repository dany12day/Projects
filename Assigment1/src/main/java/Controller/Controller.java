package Controller;

import Controller.Administrator.*;
import Controller.Employee.*;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class Controller {
    private static LoginController loginController;
    private static AdministratorController administratorController;
    private static AdministratorAddEmployeeController administratorAddEmployeeController;
    private static AdministratorReadEmployeeController administratorReadEmployeeController;
    private static AdministratorUpdateEmployeeController administratorUpdateEmployeeController;
    private static AdministratorGenerateReportEmployeeController administratorGenerateReportEmployeeController;
    private static AdministratorReportController administratorReportController;
    private static AdministratorDeleteEmployeeController administratorDeleteEmployeeController;
    private static EmployeeController employeeController;
    private static EmployeeCreateClientAccountController employeeCreateClientAccountController;
    private static EmployeeCreateClientController employeeCreateClientController;
    private static EmployeeDeleteClientAccountController employeeDeleteClientAccountController;
    private static EmployeeDeleteClientController employeeDeleteClientController;
    private static EmployeePayBillController employeePayBillController;
    private static EmployeeReadClientAccountController employeeReadClientAccountController;
    private static EmployeeReadClientController employeeReadClientController;
    private static EmployeeTransferMoneyController employeeTransferMoneyController;
    private static EmployeeUpdateClientAccountController employeeUpdateClientAccountController;
    private static EmployeeUpdateClientController employeeUpdateClientController;

    public Controller(LoginController loginController, AdministratorController administratorController, AdministratorAddEmployeeController administratorAddEmployeeController,
                      AdministratorReadEmployeeController administratorReadEmployeeController, AdministratorUpdateEmployeeController administratorUpdateEmployeeController,
                      AdministratorGenerateReportEmployeeController administratorGenerateReportEmployeeController,AdministratorReportController administratorReportController, AdministratorDeleteEmployeeController administratorDeleteEmployeeController,
                      EmployeeController employeeController, EmployeeCreateClientAccountController employeeCreateClientAccountController, EmployeeCreateClientController employeeCreateClientController,
                      EmployeeDeleteClientAccountController employeeDeleteClientAccountController,EmployeeDeleteClientController employeeDeleteClientController, EmployeePayBillController employeePayBillController,
                      EmployeeReadClientAccountController employeeReadClientAccountController,EmployeeReadClientController employeeReadClientController, EmployeeTransferMoneyController employeeTransferMoneyController,
                      EmployeeUpdateClientAccountController employeeUpdateClientAccountController,EmployeeUpdateClientController employeeUpdateClientController)
    {
        this.loginController=loginController;
        this.administratorController=administratorController;
        this.administratorAddEmployeeController = administratorAddEmployeeController;
        this.administratorReadEmployeeController=administratorReadEmployeeController;
        this.administratorUpdateEmployeeController= administratorUpdateEmployeeController;
        this.administratorGenerateReportEmployeeController= administratorGenerateReportEmployeeController;
        this.administratorReportController = administratorReportController;
        this.administratorDeleteEmployeeController = administratorDeleteEmployeeController;
        this.employeeController =employeeController;
        this.employeeCreateClientAccountController = employeeCreateClientAccountController;
        this.employeeCreateClientController = employeeCreateClientController;
        this.employeeDeleteClientAccountController = employeeDeleteClientAccountController;
        this.employeeDeleteClientController =employeeDeleteClientController;
        this.employeePayBillController = employeePayBillController;
        this.employeeReadClientAccountController=employeeReadClientAccountController;
        this.employeeReadClientController = employeeReadClientController;
        this.employeeTransferMoneyController =employeeTransferMoneyController;
        this.employeeUpdateClientAccountController = employeeUpdateClientAccountController;
        this.employeeUpdateClientController= employeeUpdateClientController;
    }

    public static LoginController getLoginController() {
        return loginController;
    }

    public static AdministratorController getAdministratorController() {
        return administratorController;
    }

    public static AdministratorAddEmployeeController getAdministratorAddEmployeeController() {
        return administratorAddEmployeeController;
    }

    public static AdministratorReadEmployeeController getAdministratorReadEmployeeController() {
        return administratorReadEmployeeController;
    }

    public static AdministratorUpdateEmployeeController getAdministratorUpdateEmployeeController() {
        return administratorUpdateEmployeeController;
    }

    public static AdministratorGenerateReportEmployeeController getAdministratorGenerateReportEmployeeController() {
        return administratorGenerateReportEmployeeController;
    }

    public static AdministratorDeleteEmployeeController getAdministratorDeleteEmployeeController() {
        return administratorDeleteEmployeeController;
    }

    public static EmployeeController getEmployeeController() {
        return employeeController;
    }

    public static EmployeeCreateClientAccountController getEmployeeCreateClientAccountController() {
        return employeeCreateClientAccountController;
    }

    public static EmployeeCreateClientController getEmployeeCreateClientController() {
        return employeeCreateClientController;
    }

    public static EmployeeDeleteClientAccountController getEmployeeDeleteClientAccountController() {
        return employeeDeleteClientAccountController;
    }

    public static EmployeeDeleteClientController getEmployeeDeleteClientController() {
        return employeeDeleteClientController;
    }

    public static EmployeePayBillController getEmployeePayBillController() {
        return employeePayBillController;
    }

    public static EmployeeReadClientAccountController getEmployeeReadClientAccountController() {
        return employeeReadClientAccountController;
    }

    public static EmployeeReadClientController getEmployeeReadClientController() {
        return employeeReadClientController;
    }

    public static EmployeeTransferMoneyController getEmployeeTransferMoneyController() {
        return employeeTransferMoneyController;
    }

    public static EmployeeUpdateClientAccountController getEmployeeUpdateClientAccountController() {
        return employeeUpdateClientAccountController;
    }

    public static EmployeeUpdateClientController getEmployeeUpdateClientController() {
        return employeeUpdateClientController;
    }

    public static AdministratorReportController getAdministratorReportController() {
        return administratorReportController;
    }
}

