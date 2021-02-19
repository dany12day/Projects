package Repository.Admin;

import Model.Employee;
import Model.Validation.Notification;
import Repository.Cache;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class AdminRepositoryCacheDecorator extends AdminRepositoryDecoration{
    AdminRepositoryMock adminRepositoryMock;
    private Cache<Employee> cache;

    public AdminRepositoryCacheDecorator(AdminRepositoryMock adminRepositoryMock, Cache<Employee> cache) {
        super(adminRepositoryMock,cache);
        this.adminRepositoryMock=adminRepositoryMock;
        this.cache= cache;
    }

    @Override
    public Notification<Boolean> saveEmployee(String name, Long idUser) {
        Notification<Boolean> saveEmployee = adminRepositoryMock.saveEmployee(name,idUser);
        return saveEmployee;
    }

    @Override
    public Notification<Boolean> modifyName(String name, Long idUser) {
        Notification<Boolean> modifyName = adminRepositoryMock.modifyName(name,idUser);
        return modifyName;
    }

    @Override
    public Notification<Boolean> deleteEmployee(Long idUser) {
        Notification<Boolean> deleteEmployee = adminRepositoryMock.deleteEmployee(idUser);
        return deleteEmployee;
    }

    @Override
    public Notification<ArrayList<String>> findAllEmployee() {
        Notification<ArrayList<String>> findAllEmployee = adminRepositoryMock.findAllEmployee();
        return findAllEmployee;
    }

    @Override
    public Notification<ArrayList<String>> findAllEmployeeActivity(Long idUser, Date dateFrom, Date dateTo) {
        Notification<ArrayList<String>> findAllEmployeeActivity = adminRepositoryMock.findAllEmployeeActivity(idUser,dateFrom,dateTo);
        return findAllEmployeeActivity;
    }

    @Override
    public Notification<Long> findEmployeeId(String name) {
        Notification<Long> findEmployeeId = adminRepositoryMock.findEmployeeId(name);
        return findEmployeeId;
    }

    @Override
    public int getSize() {
        return adminRepositoryMock.getSize();
    }


}
