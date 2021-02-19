package Repository.Admin;

import Model.Validation.Notification;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class AdminRepositoryMySQL implements AdminRepository{
    private final Connection connection;

    public AdminRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Notification<Boolean> saveEmployee(String name, Long idUser) {
        Notification<Boolean> saveEmployee = new Notification<>();
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("INSERT INTO employee values (null, ? , ?)", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, name);
            insertUserStatement.setLong(2, idUser);
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();
            saveEmployee.setResult(true);
        } catch (SQLException e) {
            e.printStackTrace();
            saveEmployee.setResult(false);
            saveEmployee.addError("Employee can not be saved");
        }
        return saveEmployee;
    }

    @Override
    public Notification<Boolean> modifyName(String name, Long idUser) {
        Notification<Boolean> modifyName = new Notification<>();
        try {
            PreparedStatement updateEmployeeStatement = connection
                    .prepareStatement("UPDATE employee SET name=? where idUser=? ", Statement.RETURN_GENERATED_KEYS);
            updateEmployeeStatement.setString(1, name);
            updateEmployeeStatement.setLong(2, idUser);
            updateEmployeeStatement.executeUpdate();

            ResultSet rs = updateEmployeeStatement.getGeneratedKeys();
            rs.next();
            modifyName.setResult(true);
        } catch (SQLException e) {
            e.printStackTrace();
            modifyName.setResult(false);
            modifyName.addError("Can not modify name");
        }
        return modifyName;
    }

    @Override
    public Notification<Boolean> deleteEmployee(Long idUser) {
        Notification<Boolean> deleteEmployee = new Notification<>();
        try {
            PreparedStatement updateEmployeeStatement = connection
                    .prepareStatement("DELETE FROM EMPLOYEE where idUser=? ", Statement.RETURN_GENERATED_KEYS);
            updateEmployeeStatement.setLong(1, idUser);
            updateEmployeeStatement.executeUpdate();

            ResultSet rs = updateEmployeeStatement.getGeneratedKeys();
            rs.next();
            deleteEmployee.setResult(true);
        } catch (SQLException e) {
            e.printStackTrace();
            deleteEmployee.setResult(false);
            deleteEmployee.addError("Can not delete employee");
        }
        return deleteEmployee;
    }

    @Override
    public Notification<ArrayList<String>> findAllEmployee() {
        Notification<ArrayList<String>> findAllEmployee = new Notification<>();
        ArrayList<String> employeeList = new ArrayList<String>();
        try {
            PreparedStatement updateEmployeeStatement = connection
                    .prepareStatement("SELECT * FROM EMPLOYEE", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = updateEmployeeStatement.executeQuery();
            while(rs.next()){
                employeeList.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            findAllEmployee.setResult(null);
            findAllEmployee.addError("Can not find any employees");
        }
        findAllEmployee.setResult(employeeList);
        return findAllEmployee;
    }

    @Override
    public Notification<ArrayList<String>> findAllEmployeeActivity(Long idUser, Date dateFrom, Date dateTo) {
        Notification<ArrayList<String>> findAllEmployeeActivity = new Notification<>();
        ArrayList<String> employeeList = new ArrayList<String>();
        try {
            PreparedStatement updateEmployeeStatement = connection
                    .prepareStatement("SELECT * FROM EMPLOYEEACTIVITY where idUser = ? and data between ? and ?", Statement.RETURN_GENERATED_KEYS);
            updateEmployeeStatement.setLong(1, idUser);
            updateEmployeeStatement.setDate(2, dateFrom);
            updateEmployeeStatement.setDate(3, dateTo);
            ResultSet rs = updateEmployeeStatement.executeQuery();
            while(rs.next()){
                employeeList.add(rs.getString("activity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            findAllEmployeeActivity.setResult(null);
            findAllEmployeeActivity.addError("Can not find any employee activities");
        }
        findAllEmployeeActivity.setResult(employeeList);
        return findAllEmployeeActivity;
    }

    @Override
    public Notification<Long> findEmployeeId(String name) {
        Notification<Long> findEmployeeId = new Notification<>();
        try {
            PreparedStatement updateEmployeeStatement = connection
                    .prepareStatement("SELECT * FROM employee where name = ? ", Statement.RETURN_GENERATED_KEYS);
            updateEmployeeStatement.setString(1, name);

            ResultSet rs = updateEmployeeStatement.executeQuery();
            rs.next();
            findEmployeeId.setResult(rs.getLong("idUser"));
        } catch (SQLException e) {
            e.printStackTrace();
            findEmployeeId.setResult(null);
            findEmployeeId.addError("Can not find the employees");
        }
        return findEmployeeId;
    }

    @Override
    public int getSize() {
        return 0;
        // nu este folosita.
    }
}
