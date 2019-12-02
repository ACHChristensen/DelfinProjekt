package delfinswimmingclub.EmployeeModel.Manager;

import delfinswimmingclub.DatabBase.MemberToSQL;
import delfinswimmingclub.DatabBase.SetMemberID;
import delfinswimmingclub.EmployeeModel.Employee;
import delfinswimmingclub.EmployeeModel.EmployeeInterface;
import delfinswimmingclub.HelpClasses.MembersGetters;
import delfinswimmingclub.Model.AgeTeam;
import delfinswimmingclub.Model.Member;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Magdalena
 */
public class ManagerIF implements EmployeeInterface {

    public ManagerIF() {
    }

    RegisterMember registerMember = new RegisterMember();
    MembersStatus membersStatus = new MembersStatus();
    MembersGetters getter = new MembersGetters();
    SelectAgeTeam selectTeam = new SelectAgeTeam();
    ChangeMembersType changeType = new ChangeMembersType();
    MemberToSQL membertoSQL = new MemberToSQL();
    

    @Override
    public void options() {
        Employee employee = new Employee("Formand", "Sebastian Bach", "abcd1234");
        System.out.println("\t\t\t Hvordan har du det " + employee.getName() + "?\n\n");
        System.out.println("tryk 1 \t for at registrere en ny medlem \n"
                + "tryk 2 \t for at ændre status på medlemen \n"
                + "tryk 3 \t for at ændre type af svømmer (motion-/konkurrencesvømmer) \n"
                + "tryk 4 \t for at logge ud \n");
    }

    @Override
    public void loggIn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loggOut() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showMenu(Employee employee, AgeTeam junior, AgeTeam senior) {

        boolean quit = false;
        while (quit == false) {
            options();

            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            in.nextLine();
            switch (input) {
                case 1: {

                    try {
                        SetMemberID setID = new SetMemberID();
                        String approve = "";
                        String confirm = "abc";
                        Member member = null;

                        while (!confirm.equals(approve)) {
                            member = registerMember.newMember();
                            member.setMemberID(setID.updateMemberID() + 1);
                            System.out.println("Medlem vil blive gemt som: \n" + member.toString()
                                    + "For at bekræfte tryk enter, for at starte registrering forfra tryk enhver karakter og enter... ");
                            in = new Scanner(System.in);
                            confirm = in.nextLine();

                        }
                        System.out.println("Medlem er blevet registreret, og vil blive tilmeldt til den passende hold");
                        selectTeam.selectTeamByAge(member, junior, senior);
                        membertoSQL.sendMemberToDB(member);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ManagerIF.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(ManagerIF.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                break;
                case 2: {

                    System.out.println("Ændring af status (activ/pasiv) \n");

                    in = new Scanner(System.in);
                    System.out.println("Giv medlemens ID og tryk på Enter: ");
                    int id = in.nextInt();
                    Member member = getter.getMemberByMemberID(id, junior, senior);

                    String status = "pasiv";
                    if (member.isActiv() == true) {
                        status = "activ";
                    }
                    System.out.println("Aktuel status på " + member.getName() + " " + member.getSurName() + "er " + status);
                    System.out.println("Status ændres...");
                    membersStatus.changeActivPasiv(member);
                    status = "activ";
                    if (member.isActiv() == true) {
                        status = "activ";
                    }
                    System.out.println("Aktuel status på " + member.getName() + " " + member.getSurName() + "er " + status);

                }
                break;
                case 3: {

                    System.out.println("Ændring af type af svømmertype (motion-/konkurrencesvømmer) \n");

                    in = new Scanner(System.in);
                    System.out.println("Giv medlemens ID og tryk på Enter: ");
                    int id = in.nextInt();
                    Member member = getter.getMemberByMemberID(id, junior, senior);

                    System.out.println("Aktuelt er medlem " + member.getFirstName() + " " + member.getSurName()
                            + " " + member.getSwimmerType());
                    changeType.changeType(member);

                    System.out.println("Nu er " + member.getFirstName() + " " + member.getSurName()
                            + " " + member.getSwimmerType());

                }
                break;
                case 4: { String answer = "abc";
                    System.out.println("Du er ved at logge ud. Er du sikker at du vil logge ud? "
                            + "tryk \"j\" for ja eller \"n\" for nej:");
                    in = new Scanner(System.in);
                    answer = in.nextLine();
                    while (!answer.equals("n") && !answer.equals("j")) {
                        System.out.println("Kan ikke genkendes svaret, prøv igen: \n "
                                + "tryk \"j\" for ja eller \"n\" for nej: ");
                        in = new Scanner(System.in);
                        answer = in.nextLine();
                    }

                    if (answer.equals("n")) {
                        System.out.println("Du bliver sendt tilbage til din menu...");
                    } else if (answer.equals("j")) {

                        quit = true;

                    }
                }

            }

        }
    }
}
