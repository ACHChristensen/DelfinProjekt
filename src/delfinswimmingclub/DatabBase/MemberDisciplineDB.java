
package delfinswimmingclub.DatabBase;

import delfinswimmingclub.Model.Disciplin;
import delfinswimmingclub.Model.Member;
import delfinswimmingclub.Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Cathrine
 */
public class MemberDisciplineDB {

    Disciplin discipline = new Disciplin();
    
    public MemberDisciplineDB() {
    }
    
    public void setMemberDisciplineToDB(String disciplineID, int memberID) throws SQLException, ClassNotFoundException{
        String discplineName = discipline.pickDisciplinNameByDisciplineID(disciplineID);
        Connection myConnector = null;
        myConnector = DBConnector.getConnection();
        PreparedStatement pstmt = null;

        //maybe , /*MemberID*/ in query1
        String query1 = "INSERT INTO delfindb.disciplines (MemberID, disciplines) VALUES (\" "
                + memberID + "\", \"" + discplineName + "\", );";
        
        /*String query2 = "INSERT INTO debtlist (MemberID, paid, price, swimmerType, active) VALUES (\" "
                + member.getMemberID() + "\", " + "; )";*/

        pstmt = myConnector.prepareStatement(query1);
        pstmt.executeUpdate(query1);

        pstmt.close();
        myConnector.close();

    }
    
    public void getMemberDisciplineFromDB() throws SQLException, ClassNotFoundException{
        Connection myConnector = null;
         myConnector = DBConnector.getConnection();
        PreparedStatement pstmt = null;

        String query = "SELECT members.firstName, members.lastName, disciplines.disciplines FROM delfindb.members"
                + " INNER JOIN members ON mebers.MemberID = disciplines.disciplines ORDER BY members.firstName";

        pstmt = myConnector.prepareStatement(query);
        pstmt.executeUpdate(query);

        ResultSet resultSet = pstmt.executeQuery(query);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        
        String columnValue;
        while (resultSet.next()) {
            columnValue = resultSet.getString(1);
            columnValue = " ";
            columnValue += resultSet.getString(2);
            columnValue += " ";
            columnValue += resultSet.getString(3);
            columnValue += "\n";
            
            System.out.print(" - "+ columnValue);}
        
        pstmt.close();
        myConnector.close();

    }
    
}
