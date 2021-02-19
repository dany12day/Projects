import Controller.*;
import Controller.Administrator.*;
import Controller.Employee.*;
import View.*;
import View.Administrator.*;
import View.Employee.*;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class Launcher {

    public static void main(String[] args) {
        ComponentFactory componentFactory = ComponentFactory.instance(false);
        new Controller(
                new LoginController(new LoginView(), componentFactory.getAuthenticationService()),
                new AdministratorController(new AdministratorView()),
                new AdministratorAddEmployeeController(new AdministratorAddEmployeeView(), componentFactory.getAdminService()),
                new AdministratorReadEmployeeController(new AdministratorReadEmployeeView(), componentFactory.getAdminService()),
                new AdministratorUpdateEmployeeController(new AdministratorUpdateEmployeeView(), componentFactory.getAdminService(), componentFactory.getAuthenticationService()),
                new AdministratorGenerateReportEmployeeController(new AdministratorGenerateReportEmployeeView(), componentFactory.getAdminService()),
                new AdministratorReportController(new AdministratorReportView(), componentFactory.getAdminService()),
                new AdministratorDeleteEmployeeController(new AdministratorDeleteEmployeeView(), componentFactory.getAdminService()),
                new EmployeeController(new EmployeeView()),
                new EmployeeCreateClientAccountController(new EmployeeCreateClientAccountView(),componentFactory.getEmployeeService()),
                new EmployeeCreateClientController(new EmployeeCreateClientView(),componentFactory.getEmployeeService()),
                new EmployeeDeleteClientAccountController(new EmployeeDeleteClientAccountView(),componentFactory.getEmployeeService()),
                new EmployeeDeleteClientController(new EmployeeDeleteClientView(),componentFactory.getEmployeeService()),
                new EmployeePayBillController(new EmployeePayBillView(),componentFactory.getEmployeeService()),
                new EmployeeReadClientAccountController(new EmployeeReadClientAccountView(),componentFactory.getEmployeeService()),
                new EmployeeReadClientController(new EmployeeReadClientView(),componentFactory.getEmployeeService()),
                new EmployeeTransferMoneyController(new EmployeeTransferMoneyView(),componentFactory.getEmployeeService()),
                new EmployeeUpdateClientAccountController(new EmployeeUpdateClientAccountView(),componentFactory.getEmployeeService()),
                new EmployeeUpdateClientController(new EmployeeUpdateClientView(),componentFactory.getEmployeeService())
        );
    }

}