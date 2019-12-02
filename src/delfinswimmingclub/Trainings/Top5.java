package delfinswimmingclub.Trainings;

import delfinswimmingclub.Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Top5 {
    
     public void top5FromDB(String discplineName) throws ClassNotFoundException, SQLException {
        Connection myConnector = null;
        myConnector = DBConnector.getConnection();
        PreparedStatement pstmt = null;

        String query = "SELECT members.firstName, members.lastName, trainingresults.Time FROM delfindb.trainingResults"
                + " INNER JOIN members ON mebers.MemberID = trainingresults.MemberID WHERE members.swimmerType = \"" 
                + discplineName +"\"ORDER BY trainingresults.Time DESC LIMIT 5;";

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
            System.out.print("Nr. "+count + " - "+ columnValue);}
        
        pstmt.close();
        myConnector.close();
    }
     
     /*public void top5RygFromDB() throws ClassNotFoundException, SQLException {
        Connection myConnector = null;
        myConnector = DBConnector.getConnection();
        PreparedStatement pstmt = null;

        String query = "SELECT members.firstName, members.lastName, trainingresults.Time FROM delfindb.trainingResults"
                + " INNER JOIN members ON mebers.MemberID = trainingresults.MemberID WHERE swimmerType = \"ryg\" "
                + "ORDER BY Time DESC LIMIT 5;";

        pstmt = myConnector.prepareStatement(query);
        pstmt.executeUpdate(query);
       
        String columnValue;
        
        ResultSet resultSet = pstmt.executeQuery(query);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int count = 0;
        while (resultSet.next()) {
            count ++;
            columnValue = resultSet.getString(1);
            columnValue += resultSet.getString(2);
             System.out.print("Nr. "+count + " - "+ columnValue);}

        pstmt.close();
        myConnector.close();
    }
     
     public void top5BrystFromDB() throws ClassNotFoundException, SQLException {
        Connection myConnector = null;
        myConnector = DBConnector.getConnection();
        PreparedStatement pstmt = null;

        String query = "SELECT members.firstName, members.lastName, trainingresults.Time FROM delfindb.trainingResults"
                + " INNER JOIN members ON mebers.MemberID = trainingresults.MemberID WHERE swimmerType = \"bry\" "
                + "ORDER BY Time DESC LIMIT 5;";

        pstmt = myConnector.prepareStatement(query);
        pstmt.executeUpdate(query);

        String columnValue;
        
        ResultSet resultSet = pstmt.executeQuery(query);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int count = 0;
        while (resultSet.next()) {
            count ++;
            columnValue = resultSet.getString(1);
            columnValue += resultSet.getString(2);
             System.out.print("Nr. "+count + " - "+ columnValue);}
        
        pstmt.close();
        myConnector.close();
    }
     
     public void top5ButFromDB() throws ClassNotFoundException, SQLException {
        Connection myConnector = null;
        myConnector = DBConnector.getConnection();
        PreparedStatement pstmt = null;

        String query = "SELECT members.firstName, members.lastName, trainingresults.Time FROM delfindb.trainingResults"
                + " INNER JOIN members ON mebers.MemberID = trainingresults.MemberID WHERE swimmerType = \"but\" "
                + "ORDER BY Time DESC LIMIT 5;";

        pstmt = myConnector.prepareStatement(query);
        pstmt.executeUpdate(query);

        String columnValue;
        
        ResultSet resultSet = pstmt.executeQuery(query);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int count = 0;
        while (resultSet.next()) {
            count ++;
            columnValue = resultSet.getString(1);
            columnValue += resultSet.getString(2);
            System.out.print("Nr. "+count + " - "+ columnValue);}
        
        pstmt.close();
        myConnector.close();
    }*/
}
