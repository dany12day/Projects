package DataBase;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class DBConnectionFactory {

    public JDBConnectionWrapper getConnectionWrapper(boolean test) {
        if (test) {
            return new JDBConnectionWrapper(Constants.Schemas.TEST);
        }
        return new JDBConnectionWrapper(Constants.Schemas.PRODUCTION);
    }

}
