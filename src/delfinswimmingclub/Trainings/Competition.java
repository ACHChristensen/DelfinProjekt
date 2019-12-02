package delfinswimmingclub.Trainings;

import delfinswimmingclub.Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Competition {
    
    public Competition() {
    }
    
     public void orderedCompetitionMembers(String discplineName) throws ClassNotFoundException, SQLException {
        Connection myConnector = null;
        myConnector = DBConnector.getConnection();
        PreparedStatement pstmt = null;
//TODO Lav en tabel i SQL som er angående konkurrence og tilpas statementet
        String query = "SELECT members.firstName, members.lastName, trainingresults.Time FROM delfindb.trainingResults"
                + " INNER JOIN members ON mebers.MemberID = trainingresults.MemberID WHERE members.swimmerType = \"" 
                + discplineName +"\"ORDER BY trainingresults.Time;";

        pstmt = myConnector.prepareStatement(query);
        pstmt.executeUpdate(query);

        ResultSet resultSet = pstmt.executeQuery(query);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        
        String columnValue;
        int count = 0;
        while (resultSet.next()) {
            count ++;
            columnValue = resultSet.getString(1);
            columnValue += resultSet.getString(2);
// TODO indsæt træningsresultater også
            System.out.print("Nr. "+count + " - "+ columnValue);}
        
        pstmt.close();
        myConnector.close();
    }
}
