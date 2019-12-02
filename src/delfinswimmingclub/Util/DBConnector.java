
package delfinswimmingclub.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Magdalena
 */
public class DBConnector {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Connection connection = null;

        String url = "jdbc:mysql://localhost:3306/DelfinDB?";
        url += "serverTimezone=UTC&allowPublicKeyRetrieaval=true&";
        url += "useSSL=false";

        String passwordCat = "1234";
        String passwordMag = "gadaMagda88";
        String user = "root";
       
        try {
            connection = DriverManager.getConnection(url, user, passwordCat);
   //         if (connection==null){
   //              connection = DriverManager.getConnection(url, user, passwordMag);
   //         }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
}
