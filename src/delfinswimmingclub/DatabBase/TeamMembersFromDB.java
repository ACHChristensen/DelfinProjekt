package delfinswimmingclub.DatabBase;

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
public class TeamMembersFromDB {

    Member member;

    public TeamMembersFromDB() {
    }

    public String getTeamMembersFromDB() throws ClassNotFoundException, SQLException {
        Connection myConnector = null;
        myConnector = DBConnector.getConnection();
        PreparedStatement pstmt = null;

        String queryAge = "SELECT members.firstName, members.lastName, members.age FROM delfindb.members;";

        pstmt = myConnector.prepareStatement(queryAge);
        pstmt.executeUpdate(queryAge);

        ResultSet resultSet = pstmt.executeQuery(queryAge);
        ResultSetMetaData rsmdAge = resultSet.getMetaData();

        String columnValue = "";
        while (resultSet.next()) {
            columnValue = resultSet.getString(1) + ";";
            columnValue += resultSet.getString(2) + ";";
            columnValue += resultSet.getInt(3) + ";";
        }
        pstmt.close();
        myConnector.close();

        return columnValue;
    }
    
    // TODO !!!!!!!!!!!!!!!!!!!
    // Denne er ikke sikker på om virker - så tjek og evt. spørg læreren
    public void showTeamMembersFromDB(String teamNameInput) throws ClassNotFoundException, SQLException {
        String members = getTeamMembersFromDB();
        String[] membersListFirstName = members.split(";", 0);
        String[] membersListLastName = members.split(";", 1);
        String[] membersListAge = members.split(";", 2);

        String firstName = member.getFirstName();
        String lastName = member.getSurName();
        int age = member.getAge();
        String teamName = "";

        firstName = membersListFirstName[0];
        lastName = membersListLastName[0];
        age = Integer.parseInt(membersListAge[0]);

        for (String ageForMemberString : membersListAge) {
            String ageforMemberString = ageForMemberString;
            int ageForMemberInt = Integer.parseInt(ageforMemberString);
            if (ageForMemberInt < 18) {
                if (teamNameInput.equals("j") || teamNameInput.equals("J")) {
                    System.out.println("Navn: " + firstName + " " + lastName + ", Alder: " + ", År: " + age
                            + " Hold : Juniorhold");
                }
            } else if (ageForMemberInt >= 18) {
                if (teamNameInput.equals("s") || teamNameInput.equals("S")) {
                    System.out.println("Navn: " + firstName + " " + lastName + ", Alder: " + ", År: " + age
                            + " Hold: Seniorhold");
                }

            }

        }
        
        //ELLERS LAV en else if stament som definerer hvad der skal i SQL "join" statementet
    }
}
