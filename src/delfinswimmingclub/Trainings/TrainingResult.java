package delfinswimmingclub.Trainings;

import delfinswimmingclub.Util.DBConnector;
import delfinswimmingclub.Model.Member;
import static java.lang.String.format;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class TrainingResult {
    Member member;
    Calendar calendar = Calendar.getInstance();

    public TrainingResult() {
       
    }
    
    public String currentDate(){

        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH)+1;


        return format("%d:%02d",date,month);
    }
    
    public void sendTrainingResultToDB(String firstMemberName, String lastMemberName, int timeInMinute, 
            int timeInSeconds, int timeInMiliSeconds) throws ClassNotFoundException, SQLException {
        
        String query = "SELECT MemberID FROM delfindb.members WHERE firstName = \'" + firstMemberName + 
                "\' AND lastName = \'" + lastMemberName + "\'";
        Connection myConnector = null;
        PreparedStatement pstmt = null;
        //Statement pstmt = null;
        ResultSet resultSet = null;
        myConnector = DBConnector.getConnection();

        pstmt = myConnector.prepareStatement(query);
        resultSet = pstmt.executeQuery();

        int memberIDFromDB = 0;
        if (resultSet.next())
            memberIDFromDB =+ resultSet.getInt("MemberID");
        
        
        int timeTotalMiliSeconds = (timeInMinute * 60 * 100) + (timeInSeconds * 100) + timeInMiliSeconds;

        String query2 = "Insert into delfindb.trainingResults (Time, Date, MemberID) values (\"" + timeTotalMiliSeconds 
                + "\" , \"" + currentDate() + "\" , " + memberIDFromDB + "  );";

        pstmt = myConnector.prepareStatement(query2);
        pstmt.executeUpdate(query2);

        resultSet.close();
        pstmt.close();
        myConnector.close();
    }
}
