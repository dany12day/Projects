package Repository.Security;

import Model.Right;
import Model.Role;
import Model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DataBase.Constants.Tables.*;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class RightsRolesRepositoryMySQL implements RightsRolesRepository{
    private final Connection connection;

    public RightsRolesRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addRole(String role) {
        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT INTO " + ROLE + " values (null, ?)");
            insertStatement.setString(1, role);
            insertStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void addRight(String right) {
        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT INTO `" + RIGHT + "` values (null, ?)");
            insertStatement.setString(1, right);
            insertStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Role findRoleByTitle(String role) {
        Statement statement;
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("select * FROM  ROLE where role = ? ", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, role);
            ResultSet rs = insertUserStatement.executeQuery();
            rs.next();
            Long roleId = rs.getLong("id");
            String roleTitle = rs.getString("role");
            return new Role(roleId, roleTitle, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role findRoleById(Long roleId) {
        Statement statement;
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("select * FROM  role where id = ? ", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setLong(1, roleId);
            ResultSet rs = insertUserStatement.executeQuery();
            rs.next();
            String roleTitle = rs.getString("role");
            return new Role(roleId, roleTitle, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Right findRightByTitle(String right) {
        Statement statement;
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("select * FROM `" + RIGHT + "` where `" + RIGHT + "` = ?", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, right);
            ResultSet rs = insertUserStatement.executeQuery();
            rs.next();
            Long rightId = rs.getLong("id");
            String rightTitle = rs.getString("right");
            return new Right(rightId, rightTitle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addRolesToUser(User user, List<Role> roles) {
        try {
            for (Role role : roles) {
                PreparedStatement insertUserRoleStatement = connection
                        .prepareStatement("INSERT INTO `user_role` values (null, ?, ?)");
                insertUserRoleStatement.setLong(1, user.getId());
                insertUserRoleStatement.setLong(2, role.getId());
                insertUserRoleStatement.executeUpdate();
            }
        } catch (SQLException e) {

        }
    }

    @Override
    public List<Role> findRolesForUser(Long userId) {
        try {
            List<Role> roles = new ArrayList<>();
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("select * FROM  user_role where user_id = ? ", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setLong(1, userId);
            ResultSet rs = insertUserStatement.executeQuery();
            while (rs.next()) {
                long roleId = rs.getLong("role_id");
                roles.add(findRoleById(roleId));
            }
            return roles;
        } catch (SQLException e) {

        }
        return null;
    }

    @Override
    public void addRoleRight(Long roleId, Long rightId) {
        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT IGNORE INTO " + ROLE_RIGHT + " values (null, ?, ?)");
            insertStatement.setLong(1, roleId);
            insertStatement.setLong(2, rightId);
            insertStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }
}
