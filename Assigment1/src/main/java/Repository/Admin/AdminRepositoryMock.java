package Repository.Admin;

import Model.Employee;
import Model.Validation.Notification;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class AdminRepositoryMock implements AdminRepository{
    private List<Employee> employee;

    public  AdminRepositoryMock(){
        employee = new ArrayList<Employee>();
    }

    @Override
    public Notification<Boolean> saveEmployee(String name, Long idUser) {
        Notification<Boolean> saveEmployee = new Notification<Boolean>();
        Employee employee = new Employee(idUser,name);
        this.employee.add(employee);
        if(this.employee.contains(employee)){
            saveEmployee.setResult(true);
        }
        else{
            saveEmployee.setResult(false);
            saveEmployee.addError("Can not add the employee");
        }
        return saveEmployee;
    }

    @Override
    public Notification<Boolean> modifyName(String name, Long idUser) {
        Notification<Boolean> modifyName = new Notification<Boolean>();
        boolean gasit = false;
        int i=0;
        for (Employee employee: this.employee) {
            if(employee.getIdUser() == idUser){
                this.employee.set(i,new Employee(idUser,name));
                gasit=true;
            }
            i++;
        }
        modifyName.setResult(gasit);
        if(!gasit){
            modifyName.addError("Employee not found");
        }
        return modifyName;
    }

    @Override
    public Notification<Boolean> deleteEmployee(Long idUser) {
        Notification<Boolean> deleteEmployee = new Notification<Boolean>();
        List<Employee> employee2 = new ArrayList<Employee>();
        boolean gasit = false;
        int i=0;
        for (Employee employee: this.employee) {
            if(employee.getIdUser() == idUser){
                gasit=true;
            }
            else{
                employee2.add(employee);
            }
            i++;
        }
        this.employee=employee2;
        deleteEmployee.setResult(gasit);
        if(!gasit){
            deleteEmployee.addError("Employee not found");
        }
        return deleteEmployee;
    }

    @Override
    public Notification<ArrayList<String>> findAllEmployee() {
        Notification<ArrayList<String>> findAllEmployee = new Notification<ArrayList<String>>();
        ArrayList<String> employeeList = new ArrayList<String>();
        int i=0;
        for (Employee employee: this.employee) {
            employeeList.add(employee.toString());
        }
        findAllEmployee.setResult(employeeList);
        if(employeeList.isEmpty()){
            findAllEmployee.addError("Employees not found");
        }
        return findAllEmployee;
    }

    @Override
    public Notification<ArrayList<String>> findAllEmployeeActivity(Long idUser, Date dateFrom, Date dateTo) {
        Notification<ArrayList<String>> findAllEmployeeActivity = new Notification<ArrayList<String>>();
        findAllEmployeeActivity.setResult(null);
        return findAllEmployeeActivity;
    }

    @Override
    public Notification<Long> findEmployeeId(String name) {
        Notification<Long> findEmployeeId = new Notification<Long>();
        findEmployeeId.setResult((long) 0);
        for (Employee employee: this.employee) {
            if(employee.getName().equals(name))
                findEmployeeId.setResult(employee.getIdUser());
        }
        if(findEmployeeId.getResult()==0){
            findEmployeeId.addError("Employee dose not exists");
        }
        return  findEmployeeId;
    }

    public int getSize(){
        return this.employee.size();
    }
}
