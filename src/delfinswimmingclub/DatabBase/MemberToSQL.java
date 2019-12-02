package delfinswimmingclub.DatabBase;

import delfinswimmingclub.Model.Member;
import delfinswimmingclub.Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Magdalena and Cathrine
 */
public class MemberToSQL {

    public MemberToSQL() {
    }
    
    public void sendMemberToDB(Member member) throws ClassNotFoundException, SQLException {

        Connection myConnector = null;
        myConnector = DBConnector.getConnection();
        PreparedStatement pstmt = null;

        //maybe , /*MemberID*/ in query1
        String query1 = "INSERT INTO delfindb.members (firstName, lastName, age, swimmerType) VALUES (\" "
                + member.getFirstName() + "\", \"" + member.getSurName() + "\", " + member.getAge() + ", \""+ 
                member.getSwimmerType() + "\"" + /*, " + member.getMemberID() +*/ " );";
        
        /*String query2 = "INSERT INTO debtlist (MemberID, paid, price, swimmerType, active) VALUES (\" "
                + member.getMemberID() + "\", " + "; )";*/

        pstmt = myConnector.prepareStatement(query1);
        pstmt.executeUpdate(query1);

        pstmt.close();
        myConnector.close();

    }

}