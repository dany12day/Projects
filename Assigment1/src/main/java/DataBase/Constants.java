package DataBase;

import java.util.*;
import static DataBase.Constants.Rights.*;
import static DataBase.Constants.Roles.*;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class Constants {

    public static class Schemas {
        public static final String TEST = "test_Bank";
        public static final String PRODUCTION = "Bank";
        public static final String[] SCHEMAS = new String[]{TEST, PRODUCTION};
    }

    public static class Tables {
        public static final String CLIENT = "client";
        public static final String ACCOUNT = "account";
        public static final String EMPLOYEE = "EMPLOYEE";
        public static final String EMPLOYEEACTIVITY = "EMPLOYEEACTIVITY";
        public static final String USER = "user";
        public static final String ROLE = "role";
        public static final String RIGHT = "right";
        public static final String ROLE_RIGHT = "role_right";
        public static final String USER_ROLE = "user_role";
        public static final String[] ORDERED_TABLES_FOR_CREATION = new String[]{USER, ROLE, RIGHT, ROLE_RIGHT, USER_ROLE, CLIENT, ACCOUNT,EMPLOYEE,EMPLOYEEACTIVITY};
    }

    public static class Roles {
        public static final String ADMINISTRATOR = "administrator";
        public static final String EMPLOYEE = "employee";
        public static final String[] ROLES = new String[]{ADMINISTRATOR, EMPLOYEE};
    }

    public static class Rights {
        public static final String CREATE_USER = "create_user";
        public static final String READ_USER = "READ_user";
        public static final String UPDATE_USER = "update_user";
        public static final String DELETE_USER = "delete_user";
        public static final String GENERATE_REPORT = "generate_report";
        public static final String ADD_CLIENT = "add_client";
        public static final String UPDATE_CLIENT = "update_client";
        public static final String VIEW_CLIENT = "view_client";
        public static final String CREATE_ACCOUNT = "create_account";
        public static final String UPDATE_ACCOUNT = "update_account";
        public static final String DELETE_ACCOUNT = "delete_account";
        public static final String VIEW_ACCOUNT = "view_account";
        public static final String[] RIGHTS = new String[]{CREATE_USER,READ_USER, UPDATE_USER, DELETE_USER, GENERATE_REPORT, ADD_CLIENT, UPDATE_CLIENT, VIEW_CLIENT, CREATE_ACCOUNT, UPDATE_ACCOUNT, DELETE_ACCOUNT, VIEW_ACCOUNT};
    }

    public static Map<String, List<String>> getRolesRights() {
        Map<String, List<String>> rolesRights = new HashMap<>();
        for (String role : ROLES) {
            rolesRights.put(role, new ArrayList<>());
        }
        rolesRights.get(ADMINISTRATOR).addAll(Arrays.asList(RIGHTS));
        rolesRights.get(EMPLOYEE).addAll(Arrays.asList(ADD_CLIENT, UPDATE_CLIENT, VIEW_CLIENT, CREATE_ACCOUNT, UPDATE_ACCOUNT, DELETE_ACCOUNT, VIEW_ACCOUNT));
        return rolesRights;
    }

}