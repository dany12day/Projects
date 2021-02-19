package Repository.Security;

import java.sql.*;
import static DataBase.Constants.Tables.USER_ROLE;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class UserRoleRepositoryMySQL implements UserRoleRepository {
    private final Connection connection;

    public UserRoleRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addUserRole(long userId, long roleId)  {
        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT IGNORE INTO " + USER_ROLE + " values (null, ?, ?)");
            insertStatement.setLong(1, userId);
            insertStatement.setLong(2, roleId);
            insertStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Long findRoleId(long userId) {
        try {
            PreparedStatement selectStatement = connection
                    .prepareStatement("SELECT role_id FROM USER_ROLE where user_id = ?");
            selectStatement.setLong(1, userId);
            ResultSet rightResultSet =  selectStatement.executeQuery();
            rightResultSet.next();
            return rightResultSet.getLong(("role_id"));
        } catch (SQLException e) {
        }
        return null;
    }
}
