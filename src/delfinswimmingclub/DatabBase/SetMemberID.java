
package delfinswimmingclub.DatabBase;

import delfinswimmingclub.Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Magdalena
 */
public class SetMemberID {

    public SetMemberID() {
    }
    // SKAL DENNE SLETTES, DA VI ALLEREDE HAR DEN I MemberIDFromDB?

    public int updateMemberID() throws ClassNotFoundException, SQLException {
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
}
