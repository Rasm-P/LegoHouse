package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class UserMapperTest {
//    Test date in the UsersTest table
//    INSERT INTO `UsersTest` VALUES 
//    (1,'jens@somewhere.com','jensen','customer'),
//    (2,'ken@somewhere.com','kensen','customer'),
//    (3,'robin@somewhere.com','batman','employee'),
//    (4,'someone@nowhere.com','sesam','customer');

    private static Connection testConnection;
    private static String USER = "LegoReader";
    private static String USERPW = "LegoHouse1998";
    private static String DBNAME = "useradmin";
    private static String HOST = "178.62.228.96";
    
    //private static String USER = "root";
    //private static String USERPW = "1234";
    //private static String DBNAME = "useradmin";
    //private static String HOST = "localhost";

    @Before
    public void setUp() {
        try {
            // awoid making a new connection for each test
            if (testConnection == null) {
                String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
                Class.forName("com.mysql.cj.jdbc.Driver");

                testConnection = DriverManager.getConnection(url, USER, USERPW);
                // Make mappers use test 
                Connector.setConnection(testConnection);
            }
            // reset test database
            try (Statement stmt = testConnection.createStatement()) {
                stmt.execute("drop table if exists userstest");
                stmt.execute("create table userstest like user");
                stmt.execute("insert into userstest select * from user");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull(testConnection);
    }

    @Test
    public void testLogin01() throws LoginSampleException {
        // Can we log in
        User user = UserMapper.login("jens@somewhere.com", "jensen");
        assertTrue(user != null);
    }

    @Test(expected = LoginSampleException.class)
    public void testLogin02() throws LoginSampleException {
        // We should get an exception if we use the wrong password
        User user = UserMapper.login("jens@somewhere.com", "larsen");
    }

    @Test
    public void testLogin03() throws LoginSampleException {
        // Jens is supposed to be a customer
        User user = UserMapper.login("jens@somewhere.com", "jensen");
        assertEquals("customer", user.getRole());
    }

    @Test
    public void testCreateUser01() throws LoginSampleException {
        // Can we create a new user - Notice, if login fails, this will fail
        // but so would login01, so this is OK
        // Changed the test to that it does not completely delete the database, and therefore need these new sql statemens below
        User original = new User("king@kong.com", "uhahvorhemmeligt", "konge");

        try {
            String SQL = "INSERT INTO userstest (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = testConnection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, original.getEmail());
            ps.setString(2, original.getPassword());
            ps.setString(3, original.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            original.setId(id);
        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        try {
            String SQL = "SELECT id, role FROM userstest "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = testConnection.prepareStatement(SQL);
            ps.setString(1, original.getEmail());
            ps.setString(2, original.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(original.getEmail(), original.getPassword(), role);
                user.setId(id);
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        assertEquals("konge", original.getRole());
    }
}
