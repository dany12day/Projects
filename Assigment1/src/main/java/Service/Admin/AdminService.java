package Service.Admin;

import Model.Validation.Notification;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public interface AdminService {
    public Notification<Boolean> addEmployee(String name, String userName, String password);
    public Notification<Boolean> updateName(String username, String password, String newName);
    public Notification<Boolean> deleteEmployee(String username, String password);
    public Notification<ArrayList<String>> printEmployeeList();
    Notification<ArrayList<String>> printEmployeeActivityList(String name, Date dateFrom, Date dateTo);
}
