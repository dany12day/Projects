package Repository.User;

import Model.User;
import Model.Builder.UserBuilder;
import Model.Validation.Notification;
import OtherConstants.Constants;
import Repository.Security.RightsRolesRepository;
import Repository.Security.UserRoleRepository;
import java.sql.*;
import java.util.List;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class UserRepositoryMySQL implements UserRepository {
    private final Connection connection;
    private final RightsRolesRepository rightsRolesRepository;
    private final UserRoleRepository userRoleRepository;

    public UserRepositoryMySQL(Connection connection, RightsRolesRepository rightsRolesRepository, UserRoleRepository userRoleRepository) {
        this.connection = connection;
        this.rightsRolesRepository = rightsRolesRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Notification<User> findByUsernameAndPassword(String username, String password) throws AuthenticationException {
        Notification<User> findByUsernameAndPasswordNotification = new Notification<>();
        try {
            PreparedStatement selectStatement = connection
                    .prepareStatement("SELECT * FROM user where username = ? and password = ?");
            selectStatement.setString(1, username);
            selectStatement.setString(2, password);
            ResultSet rightResultSet =  selectStatement.executeQuery();
            if (rightResultSet.next()) {
                User user = new UserBuilder()
                        .setUsername(rightResultSet.getString("username"))
                        .setPassword(rightResultSet.getString("password"))
                        .setRoles(rightsRolesRepository.findRolesForUser(rightResultSet.getLong("id")))
                        .build();
                findByUsernameAndPasswordNotification.setResult(user);
                Constants.CurrentEmployee.setCurrentEmployee(rightResultSet.getLong("id"));
                return findByUsernameAndPasswordNotification;
            } else {
                findByUsernameAndPasswordNotification.addError("Invalid email or password!");
                return findByUsernameAndPasswordNotification;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AuthenticationException();
        }
    }

    @Override
    public Notification<Boolean> saveUser(User user) {
        Notification<Boolean> saveUser = new Notification<>();
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("INSERT INTO user values (null, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, user.getUsername());
            insertUserStatement.setString(2, user.getPassword());
            insertUserStatement.executeUpdate();
            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();
            long userId = rs.getLong(1);
            user.setId(userId);
            userRoleRepository.addUserRole(userId, 2);
            saveUser.setResult(true);
        } catch (SQLException e) {
            e.printStackTrace();
            saveUser.setResult(false);
            saveUser.addError("Invalid email or password!");
        }
        return saveUser;
    }

    @Override
    public Notification<Boolean> deleteUserRole(Long idUser) {
        Notification<Boolean> deleteUserRole = new Notification<>();
        try {
            PreparedStatement updateEmployeeStatement = connection
                    .prepareStatement("DELETE FROM USER_ROLE where user_id=? ", Statement.RETURN_GENERATED_KEYS);
            updateEmployeeStatement.setLong(1, idUser);
            updateEmployeeStatement.executeUpdate();
            ResultSet rs = updateEmployeeStatement.getGeneratedKeys();
            rs.next();
            deleteUserRole.setResult(true);
        } catch (SQLException e) {
            e.printStackTrace();
            deleteUserRole.setResult(false);
            deleteUserRole.addError("Can not delete userRole");
        }
        return deleteUserRole;
    }

    @Override
    public Notification<Boolean> deleteUser(Long idUser) {
        Notification<Boolean> deleteUser = new Notification<>();
        try {
            PreparedStatement updateEmployeeStatement = connection
                    .prepareStatement("DELETE FROM USER where id=? ", Statement.RETURN_GENERATED_KEYS);
            updateEmployeeStatement.setLong(1, idUser);
            updateEmployeeStatement.executeUpdate();

            ResultSet rs = updateEmployeeStatement.getGeneratedKeys();
            rs.next();
            deleteUser.setResult(true);
        } catch (SQLException e) {
            e.printStackTrace();
            deleteUser.setResult(false);
            deleteUser.addError("Can not delete user");
        }
        return deleteUser;
    }

    @Override
    public void removeAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE from user where id >= 0";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Notification<Long>  findUserId(String username, String password) throws AuthenticationException{
        Notification<Long> UserId = new Notification<>();
        try {
            PreparedStatement selectStatement = connection
                    .prepareStatement("SELECT id FROM user where username = ? and password = ?");
            selectStatement.setString(1, username);
            selectStatement.setString(2, password);
            ResultSet rightResultSet =  selectStatement.executeQuery();
            rightResultSet.next();
            UserId.setResult(rightResultSet.getLong(("id")));
        } catch (SQLException e) {
            UserId.setResult((long) 0);
            UserId.addError("User Id not found");
        }
        return UserId;
    }

    @Override
    public Notification<Boolean> modifyUsername(String username, Long idUser) {
        Notification<Boolean> modifyUsername = new Notification<>();
        try {
            PreparedStatement updateEmployeeStatement = connection
                    .prepareStatement("UPDATE User SET username=? where id=? ", Statement.RETURN_GENERATED_KEYS);
            updateEmployeeStatement.setString(1, username);
            updateEmployeeStatement.setLong(2, idUser);
            updateEmployeeStatement.executeUpdate();
            ResultSet rs = updateEmployeeStatement.getGeneratedKeys();
            rs.next();
            modifyUsername.setResult(true);
        } catch (SQLException e) {
            e.printStackTrace();
            modifyUsername.setResult(false);
            modifyUsername.addError("Can not modify username");
        }
        return modifyUsername;
    }

    @Override
    public Notification<Boolean> modifyPassword(String password, Long idUser) {
        Notification<Boolean> modifyPassword = new Notification<>();
        try {
            PreparedStatement updateEmployeeStatement = connection
                    .prepareStatement("UPDATE User SET password=? where id=? ", Statement.RETURN_GENERATED_KEYS);
            updateEmployeeStatement.setString(1, password);
            updateEmployeeStatement.setLong(2, idUser);
            updateEmployeeStatement.executeUpdate();
            ResultSet rs = updateEmployeeStatement.getGeneratedKeys();
            rs.next();
            modifyPassword.setResult(true);
        } catch (SQLException e) {
            e.printStackTrace();
            modifyPassword.setResult(false);
            modifyPassword.addError("Can not modify password");
        }
        return modifyPassword;
    }
}
