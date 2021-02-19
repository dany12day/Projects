package DataBase;

import Repository.Security.RightsRolesRepository;
import Repository.Security.RightsRolesRepositoryMySQL;
import Service.UsefullFunctions.EncodePassword;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static DataBase.Constants.Rights.RIGHTS;
import static DataBase.Constants.Roles.ROLES;
import static DataBase.Constants.Schemas.SCHEMAS;
import static DataBase.Constants.getRolesRights;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class Bootstrap {

    private static RightsRolesRepository rightsRolesRepository;

    public static void main(String[] args) throws SQLException {
        dropAll();
        bootstrapTables();
        bootstrapUserData();
        insertAdmin();
    }

    private static void dropAll() throws SQLException {
        for (String schema : SCHEMAS) {
            System.out.println("Dropping all tables in schema: " + schema);
            Connection connection = new JDBConnectionWrapper(schema).getConnection();
            Statement statement = connection.createStatement();
            String[] dropStatements = {
                    "TRUNCATE `role_right`;",
                    "DROP TABLE `role_right`;",
                    "TRUNCATE `right`;",
                    "TRUNCATE `user_role`;",
                    "DROP TABLE `user_role`;",
                    "TRUNCATE `role`;",
                    "TRUNCATE `employee`;",
                    "TRUNCATE `employeeactivity`;",
                    "DROP TABLE  `client`,`account`, `role`, `user`, `employee`, `employeeactivity`;"
            };
            Arrays.stream(dropStatements).forEach(dropStatement -> {
                try {
                    statement.execute(dropStatement);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("Done table bootstrap");
    }

    private static void bootstrapTables() throws SQLException {
        SQLTableCreationFactory sqlTableCreationFactory = new SQLTableCreationFactory();
        for (String schema : SCHEMAS) {
            System.out.println("Bootstrapping " + schema + " schema");
            JDBConnectionWrapper connectionWrapper = new JDBConnectionWrapper(schema);
            Connection connection = connectionWrapper.getConnection();
            Statement statement = connection.createStatement();
            for (String table : Constants.Tables.ORDERED_TABLES_FOR_CREATION) {
                String createTableSQL = sqlTableCreationFactory.getCreateSQLForTable(table);
                statement.execute(createTableSQL);
            }
        }
        System.out.println("Done table bootstrap");
    }

    private static void bootstrapUserData() throws SQLException {
        for (String schema : SCHEMAS) {
            System.out.println("Bootstrapping user data for " + schema);
            JDBConnectionWrapper connectionWrapper = new JDBConnectionWrapper(schema);
            rightsRolesRepository = new RightsRolesRepositoryMySQL(connectionWrapper.getConnection());
            bootstrapRoles();
            bootstrapRights();
            bootstrapRoleRight();
        }
    }

    private static void bootstrapRoles() throws SQLException {
        for (String role : ROLES) {
            rightsRolesRepository.addRole(role);
        }
    }

    private static void bootstrapRights() throws SQLException {
        for (String right : RIGHTS) {
            rightsRolesRepository.addRight(right);
        }
    }

    private static void bootstrapRoleRight() throws SQLException {
        Map<String, List<String>> rolesRights = getRolesRights();
        for (String role : rolesRights.keySet()) {
            Long roleId = rightsRolesRepository.findRoleByTitle(role).getId();
            for (String right : rolesRights.get(role)) {
                Long rightId = rightsRolesRepository.findRightByTitle(right).getId();
                rightsRolesRepository.addRoleRight(roleId, rightId);
            }
        }
    }

    private static void insertAdmin() throws SQLException {
        for (String schema : SCHEMAS) {
            System.out.println("Insert admin in schema: " + schema);
            Connection connection = new JDBConnectionWrapper(schema).getConnection();
            Statement statement = connection.createStatement();
            String pas1 = "dadadada1#";
            pas1 = EncodePassword.encodePassword(pas1);
            String pas2 = "dadadada2#";
            pas2 = EncodePassword.encodePassword(pas2);
            String pas3 = "dadadada3#";
            pas3 = EncodePassword.encodePassword(pas3);
            String[] insertAdminUser = {
                    "insert into user(username,password) values" +
                            "('Daniel1@gmail.com','"+pas1+"'), "+
                            "('Daniel2@gmail.com','"+pas2+"')," +
                            "('Daniel3@gmail.com','"+pas3+"');"
            };
            Arrays.stream(insertAdminUser).forEach(insertStatement -> {
                try {
                    statement.execute(insertStatement);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            String[] insertAdminRole = {
                    "insert into user_role(user_id,role_id) values" +
                            "('1','1'), "+
                            "('2','1')," +
                            "('3','1');"
            };
            Arrays.stream(insertAdminRole).forEach(insertStatement -> {
                try {
                    statement.execute(insertStatement);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("Done table bootstrap");
    }

}