package Service.Admin;

import Model.Employee;
import Model.User;
import Model.Validation.Notification;
import Service.UsefullFunctions.Validators.EmployeeValidator;
import Repository.Admin.AdminRepository;
import Repository.User.AuthenticationException;
import Repository.User.UserRepository;
import Service.UsefullFunctions.EncodePassword;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class AdminServiceMySQL implements  AdminService{
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    public AdminServiceMySQL(UserRepository userRepository, AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public Notification<Boolean> addEmployee(String name, String username, String password) {
        Employee employee = new Employee((long) 0,name);
        EmployeeValidator employeeValidator = new EmployeeValidator(employee);
        boolean employeeValid = employeeValidator.validate();
        Notification<Boolean> addEmployee = new Notification<>();
        if (!employeeValid) {
            employeeValidator.getErrors().forEach(addEmployee::addError);
            addEmployee.setResult(Boolean.FALSE);
        } else {
            User user = new User();
            user.setPassword(EncodePassword.encodePassword(password));
            user.setUsername(username);
            addEmployee= userRepository.saveUser(user);
            if(addEmployee.getResult()) {
                Notification<Long> idUser = null;
                try {
                    idUser = userRepository.findUserId(username, EncodePassword.encodePassword(password));
                } catch (AuthenticationException e) {
                    idUser.setResult((long) 0);
                    addEmployee.addError("User dose not exists");
                    addEmployee.setResult(false);
                    return addEmployee;
                }
                if(idUser.getResult()!=0)
                    addEmployee=adminRepository.saveEmployee(name, idUser.getResult());
                else{
                    addEmployee.addError(idUser.getFormattedErrors());
                    addEmployee.setResult(false);
                }
            }
        }
        return addEmployee;
    }

    @Override
    public Notification<Boolean> updateName(String username, String password, String newName) {
        Notification<Boolean> updateName = new Notification<>();
        Notification<Long> idUser = null;
        try {
            idUser = userRepository.findUserId(username, EncodePassword.encodePassword(password));
        } catch (AuthenticationException e) {
        }
        if(idUser.hasErrors()){
            idUser.setResult((long) 0);
            updateName.addError("User dose not exists");
            updateName.setResult(false);
            return updateName;
        }
        if(idUser.getResult()!=0)
            updateName=adminRepository.modifyName(newName,idUser.getResult());
        else {
            updateName.addError(idUser.getFormattedErrors());
            updateName.setResult(false);
        }
        return updateName;



    }


    @Override
    public Notification<Boolean> deleteEmployee(String username, String password) {
        Notification<Boolean> deleteEmployee = new Notification<>();
        Notification<Long> idUser = null;
        try {
            idUser = userRepository.findUserId(username, EncodePassword.encodePassword(password));
        } catch (AuthenticationException e) {

        }
        if (idUser.hasErrors()) {
            idUser.setResult((long) 0);
            deleteEmployee.addError("User dose not exists");
            deleteEmployee.setResult(false);
            return deleteEmployee;
        }
        if (idUser.getResult() != 0){
            deleteEmployee = adminRepository.deleteEmployee(idUser.getResult());
            if (deleteEmployee.hasErrors()) {
                deleteEmployee.addError("The employee was not found");
                deleteEmployee.setResult(false);
                return deleteEmployee;
            }
            deleteEmployee = userRepository.deleteUser(idUser.getResult());
            if (deleteEmployee.hasErrors()) {
                deleteEmployee.addError("The user was not found");
                deleteEmployee.setResult(false);
                return deleteEmployee;
            }
            deleteEmployee = userRepository.deleteUserRole(idUser.getResult());
            if (deleteEmployee.hasErrors()) {
                deleteEmployee.addError("The userRole was not found");
                deleteEmployee.setResult(false);
                return deleteEmployee;
            }
        }
        else{
            deleteEmployee.addError(idUser.getFormattedErrors());
            deleteEmployee.setResult(false);
        }
        deleteEmployee.setResult(true);
        return deleteEmployee;
    }

    @Override
    public Notification<ArrayList<String>> printEmployeeList() {
        Notification<ArrayList<String>> printEmployeeList = new Notification<>();
        printEmployeeList= adminRepository.findAllEmployee();
        return printEmployeeList;
    }

    @Override
    public Notification<ArrayList<String>> printEmployeeActivityList(String name, Date dateFrom, Date dateTo) {
        Notification<ArrayList<String>> printEmployeeActivityList = new Notification<>();
        Notification<Long> idUser = adminRepository.findEmployeeId(name);
        if(idUser.hasErrors()){
            printEmployeeActivityList.addError(idUser.getFormattedErrors());
            return  printEmployeeActivityList;
        }
        printEmployeeActivityList= adminRepository.findAllEmployeeActivity(idUser.getResult(),dateFrom,dateTo);
        return printEmployeeActivityList;
    }


}
