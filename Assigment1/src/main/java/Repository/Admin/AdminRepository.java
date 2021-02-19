package Repository.Admin;

import Model.Validation.Notification;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public interface AdminRepository {
    public Notification<Boolean> saveEmployee(String name, Long idUser);
    public Notification<Boolean> modifyName(String name, Long idUser);
    public Notification<Boolean> deleteEmployee(Long idUser);
    Notification<ArrayList<String>> findAllEmployee();
    Notification<ArrayList<String>> findAllEmployeeActivity(Long idUser, Date dateFrom, Date dateTo);
    public Notification<Long> findEmployeeId(String name);
    public int getSize();
}
