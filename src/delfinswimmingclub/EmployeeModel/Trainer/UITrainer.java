package delfinswimmingclub.EmployeeModel.Trainer;

import delfinswimmingclub.DatabBase.MemberDisciplineDB;
import delfinswimmingclub.DatabBase.MemberIDFromDB;
import delfinswimmingclub.DatabBase.TeamMembersFromDB;
import delfinswimmingclub.Trainings.Competition;
import delfinswimmingclub.Trainings.Top5;
import delfinswimmingclub.Trainings.TrainingResult;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cathrine
 */
public class UITrainer {

    Scanner myScan;
    TrainingResult trainingResult = new TrainingResult();
    MemberDisciplineDB memberDisciplineDB = new MemberDisciplineDB();
    MemberIDFromDB memberIDFromDB = new MemberIDFromDB();
    Top5 top5 = new Top5();
    MemberDisciplineDB memberDiscipline = new MemberDisciplineDB();
    TeamMembersFromDB teamMembers = new TeamMembersFromDB();
    Competition competition = new Competition();

    public UITrainer() {
    }

    public void menuForRegisterMemberTraining() {
        myScan = new Scanner(System.in);
        System.out.println("Hvilket medlem for hvilket medlem du ønsker at registrer bedste "
                + "trænningsresultat \n Fornavn: ");
        String memberFirstName = myScan.nextLine();
        System.out.println("Efternavn:");
        String memberLastName = myScan.nextLine();
        System.out.println("Skriv tiden herunder");
        System.out.println("Antal minutter:");
        int minutesForMember = myScan.nextInt();
        System.out.println("Antal sekunder:");
        int secondsForMember = myScan.nextInt();
        System.out.println("Antal milisekunder:");
        int miliSecondsForMember = myScan.nextInt();
        try {
            trainingResult.sendTrainingResultToDB(memberFirstName, memberLastName, minutesForMember,
                    secondsForMember, miliSecondsForMember);
            System.out.println("... Dit medlem: " + memberFirstName + " " + memberLastName + " er nu registreret med "
                    + "dagens bedste trænningsresultat på: " + minutesForMember + " minutter " + secondsForMember
                    + " sekunder " + miliSecondsForMember + " milisekunder");

        } catch (ClassNotFoundException ex) {
            System.out.println("SYSTEMFEJL ! - Medlemmer blev ikke fundet");
        } catch (SQLException ex) {
            System.out.println("SYSTEMFEJL ! - Kunne ikke oprette forbindelse til databasen");
        }
    }

// TODO !!!!!!!!!!!!!!!!!!
// ordne denne metode så den virker til SQL
    public void menuForRegisterMemberDiscipline() {
        myScan = new Scanner(System.in);
        boolean quit = false;
        System.out.println("Indtast oplysninger om medlem");
        System.out.println("Fornavn: ");
        String MemberFirstName = myScan.nextLine();
        System.out.println("Efternavn: ");
        String MemberLastName = myScan.nextLine();
        while (quit == false) {
            myScan = new Scanner(System.in);
            System.out.println("\nIndtast svømmedisciplinens ID med små bogstaver");
            System.out.println(" - Indtast 0 for at se ID'erne og enter ");
            System.out.println(" - ellers indtast e og enter for at vende tilbage til menuen\n");
            String discipline = myScan.nextLine();

            if (discipline.equals("e") || discipline.equals("E")) {
                quit = true;

            } else {
                try {
                    myScan = new Scanner(System.in);
                    int memberIDDB = memberIDFromDB.GetMemberIDFromDB(MemberFirstName, MemberLastName);
                    memberDisciplineDB.setMemberDisciplineToDB(discipline, memberIDDB);
                } catch (SQLException ex) {
                    System.out.println("SYSTEMFEJL ! - Kunne ikke oprette forbindelse til databasen");
                } catch (ClassNotFoundException ex) {
                    System.out.println("SYSTEMFEJL ! - Medlem kunne ikke registreres");
                }

            }
        }
    }

    public void menuForGetTop5() {
        myScan = new Scanner(System.in);
        System.out.println("Hvilken svømmedisciplin vil du se top 5 på?");
        System.out.println("(Indtastning skal være med små bogstaver)");
        System.out.println("Indtast \"cra\" for \t Crawl");
        System.out.println("Indtast \"bry\" for Brystsvømning");
        System.out.println("Indtast \"ryg\" for Rygcrawl");
        System.out.println("Indtast \"but\" for Butterfly");
        String input2 = myScan.nextLine();
        try {
            top5.top5FromDB(input2);
        } catch (ClassNotFoundException ex) {
            System.out.println("SYSTEMFEJL ! - Medlemmer blev ikke fundet");
        } catch (SQLException ex) {
            System.out.println("SYSTEMFEJL ! - Kunne ikke oprette forbindelse til databasen");
        }
    }

    public void menuForGetMemberAndDiscipline() {
        myScan = new Scanner(System.in);
        System.out.println("Her er listen over medlemmer og deres disciplin:\n\n");
        String input3 = myScan.nextLine();
        try {
            memberDiscipline.getMemberDisciplineFromDB();
        } catch (SQLException ex) {
//TODO - ændrer disse fejlmeddelser 
            Logger.getLogger(UITrainer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UITrainer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void menuForGetTeamMembers() throws ClassNotFoundException, SQLException {
        myScan = new Scanner(System.in);
        System.out.println("Vælg hold for at se medlemmer\n\n");
        System.out.println("Indtast j for juniorholdet og s for Seniorholdet");
        System.out.println("\"Senior\"");
        System.out.println("\"Junior\"");
        String input3 = myScan.nextLine();
        teamMembers.showTeamMembersFromDB(input3);
        {

        }
    }

    public void orderedMembersInCompetitions() {
        myScan = new Scanner(System.in);
        System.out.println("Hvilken svømmedisciplin vil du se konkurrenceresultaterne på?");
        System.out.println("(Indtastning skal være med små bogstaver)");
        System.out.println("Indtast \"cra\" for \t Crawl");
        System.out.println("Indtast \"bry\" for Brystsvømning");
        System.out.println("Indtast \"ryg\" for Rygcrawl");
        System.out.println("Indtast \"but\" for Butterfly");
        String input5 = myScan.nextLine();
        try {
            competition.orderedCompetitionMembers(input5);
        } catch (ClassNotFoundException ex) {
            System.out.println("SYSTEMFEJL ! - Medlemmer blev ikke fundet");
        } catch (SQLException ex) {
            System.out.println("SYSTEMFEJL ! - Kunne ikke oprette forbindelse til databasen");
        }

    }
}
