package delfinswimmingclub.EmployeeModel.Trainer;

import delfinswimmingclub.EmployeeModel.Employee;
import delfinswimmingclub.EmployeeModel.EmployeeInterface;
import delfinswimmingclub.Model.AgeTeam;
import java.sql.SQLException;
import java.util.Scanner;

public class TrainerIF implements EmployeeInterface {

    UITrainer uiTrainer = new UITrainer();

    public TrainerIF() {
    }
    
    @Override
    public void options() {
        Employee trainer = new Employee("Træner", "Ludwig Poulsen", "10hi");
        System.out.println("\t\t\t Hvordan har du det " + trainer.getName() + "?\n\n");
            System.out.println("tryk 1 \t for at tilføje et trænningsresultat af medlem\t \n"
                    + "tryk 2 \t for at sætte et medlem til en svømmediscplin\n"
                    + "tryk 3 \t for at se top 5 af en bestemt svømmediscplin\n"
                    + "tryk 4 \t for at se medlemmer og deres svømmediscplin\n"
                    + "tryk 5 \t for at se konkurrencer og sorteret resultater\n"
                    + "tryk 6 \t for at se medlemmer på de to hold\n"
                    + "tryk 0 \t for logge ud\n");
    }

    @Override
    public void loggIn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loggOut() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//TODO Lav sådan at når man går ud af en undermenu, så kommer man tilbage til hovedTrænerMenuen
    @Override
    public void showMenu(Employee employee, AgeTeam junior, AgeTeam senior) {
        boolean quit = false;
        while (quit == false) {
            options();
            Scanner myScan = new Scanner(System.in);
            int input = myScan.nextInt();
            myScan.nextLine();
            switch (input) {
                case 1: {
                    uiTrainer.menuForRegisterMemberTraining();
                }
                case 2: {
                    uiTrainer.menuForRegisterMemberDiscipline();
                }
                case 3: {
                    uiTrainer.menuForGetTop5();
                }
                case 4: {
                    uiTrainer.menuForGetMemberAndDiscipline();
                }
                case 5: {
                    uiTrainer.orderedMembersInCompetitions();
                }
                case 6: {
                try {
                    uiTrainer.menuForGetTeamMembers();
                } catch (ClassNotFoundException ex) {
                    System.out.println("FEJL - Medlemmer er ikke fundet");
                } catch (SQLException ex) {
                    System.out.println("FEJL - Kunne ikke oprette forbindelse til server");
                }
                }
                case 0: {
                    
                    System.out.println("Du er ved at logge ud. Er du sikker at du vil logge ud? "
                            + "tryk \"j\" for ja eller \"n\" for nej:");
                    String inputJN = myScan.nextLine();
                    while (!inputJN.equals("n") && !inputJN.equals("j")) {
                        System.out.println("Kan ikke genkendes svaret, prøv igen: \n "
                                + "tryk \"j\" for ja eller \"n\" for nej: ");
                        inputJN = myScan.nextLine();
                    }

                    if (inputJN.equals("n")) {
                        System.out.println("Du bliver sendt tilbage til din menu...");
                    } else if (inputJN.equals("j")) {
                    quit = true;
                    System.out.println( "Du er nu logget af, "+ employee.getName());
                }}

            }
        }

    }

}
