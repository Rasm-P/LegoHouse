package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rasmus2
 */
public class Connector {

    private static final String URL = "jdbc:mysql://178.62.228.96:3306/useradmin";
    private static final String USERNAME = "LegoReader";
    private static final String PASSWORD = "LegoHouse1998";
    
    //private static final String URL = "jdbc:mysql://localhost:3306/useradmin";
    //private static final String USERNAME = "root";
    //private static final String PASSWORD = "1234";

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }

}
