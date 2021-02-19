import DataBase.DBConnectionFactory;

import Repository.Admin.AdminRepository;
import Repository.Admin.AdminRepositoryMySQL;
import Repository.Employee.EmployeeRepository;
import Repository.Employee.EmployeeRepositoryMySQL;
import Repository.Security.RightsRolesRepository;
import Repository.Security.RightsRolesRepositoryMySQL;
import Repository.Security.UserRoleRepository;
import Repository.Security.UserRoleRepositoryMySQL;
import Repository.User.UserRepository;
import Repository.User.UserRepositoryMySQL;
import Service.Admin.AdminService;
import Service.Admin.AdminServiceMySQL;
import Service.Employee.EmployeeService;
import Service.Employee.EmployeeServiceMySQL;
import Service.User.AuthenticationService;
import Service.User.AuthenticationServiceMySQL;
import java.sql.Connection;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class ComponentFactory {
    private final AdminService adminService;
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final RightsRolesRepository rightsRolesRepository;
    private final UserRoleRepository userRoleRepository;
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;
    private static ComponentFactory instance;

    public static ComponentFactory instance(Boolean componentsForTests) {
        if (instance == null) {
            instance = new ComponentFactory(componentsForTests);
        }
        return instance;
    }

    private ComponentFactory(Boolean componentsForTests) {
        Connection connection = new DBConnectionFactory().getConnectionWrapper(componentsForTests).getConnection();
        this.rightsRolesRepository = new RightsRolesRepositoryMySQL(connection);
        this.userRoleRepository = new UserRoleRepositoryMySQL(connection);
        this.userRepository = new UserRepositoryMySQL(connection, rightsRolesRepository, userRoleRepository);
        this.adminRepository = new AdminRepositoryMySQL(connection);
        this.employeeRepository = new EmployeeRepositoryMySQL(connection);
        this.authenticationService = new AuthenticationServiceMySQL(this.userRepository, this.rightsRolesRepository,this.userRoleRepository );
        this.adminService = new AdminServiceMySQL(this.userRepository, this.adminRepository);
        this.employeeService = new EmployeeServiceMySQL(this.userRepository,this.employeeRepository);

    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public RightsRolesRepository getRightsRolesRepository() {
        return rightsRolesRepository;
    }

    public AdminRepository getAdminRepository() {
        return adminRepository;
    }

    public UserRoleRepository getUserRoleRepository() {
        return userRoleRepository;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public static ComponentFactory getInstance() {
        return instance;
    }
}