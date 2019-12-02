
package delfinswimmingclub.DatabBase;

import delfinswimmingclub.Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Magdalena og Cathrine
 */
public class MemberIDFromDB {

    public MemberIDFromDB() {
    }
    
   /* public int updateMemberID() throws ClassNotFoundException, SQLException {
        int memberID = 0;
        String query = "Select MemberId from delfindb.members order by MemberId;";

        PreparedStatement pstmt = null;
        Connection myConnector = null;
        ResultSet resSet = null;
        myConnector = DBConnector.getConnection();

        String sql = "SELECT MAX(MemberId) AS result FROM delfindb.members;";
        ResultSet rs = DBConnector.getConnection().prepareStatement(sql).executeQuery();
        if (rs.next()) {
            memberID = rs.getInt("result");
        }
        return memberID;
    }
*/
    
    public int GetMemberIDFromDB(String firstName, String lastName) throws ClassNotFoundException, SQLException {
        String query = "SELECT MemberId FROM delfindb.members WHERE firstName = \""+ firstName 
                + "\" AND lastName = \"" + lastName + "\";";

        PreparedStatement pstmt = null;
        Connection myConnector = null;
        ResultSet resSet = null;
        myConnector = DBConnector.getConnection();

        int memberID = 0;
        resSet = DBConnector.getConnection().prepareStatement(query).executeQuery();
        if (resSet.next()) {
            memberID = resSet.getInt(1);
            return memberID;
        }
        return 0;
    }
}
