/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinswimmingclub.EmployeeModel.Cashier;

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
public class CashierIF implements EmployeeInterface {

    AddNewPayment newPayment = new AddNewPayment();
    MembersGetters getter = new MembersGetters();
    Debt debt = new Debt();
    YearlyFacture facture = new YearlyFacture();
    Balance balance = new Balance();

    @Override
    public void options() {
        Employee employee = new Employee("Kasserer", "Trine Jensen", "abcd1234");
        System.out.println("\t\t\t Hvordan har du det " + employee.getName() + "?\n\n");
        System.out.println("tryk 1 \t for at registrere en ny betaling \n"
                + "tryk 2 \t for at vise saldo af alle medlemmerne \n"
                + "tryk 3 \t for at vise restance \n"
                + "tryk 4 \t for at opdatere årlige kontignenter  \n"
                + "tryk 5 \t for at logge ud \n");
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
                    System.out.println("Registrering af ny betaling:\n"
                            + "Registrering sker ved at angive Medlems ID nummer og indbetalt beløb:\n");
                    Member member = null;
                    int memberID = 0;
                    double amount = 0;
                    while (member == null) {
                        System.out.println("Giv medlems ID nummer og tryk enter:");

                        in = new Scanner(System.in);
                        String inputID = in.nextLine();
                        try {
                            memberID = Integer.parseInt(inputID);
                        } catch (NumberFormatException nfe) {
                            System.out.println("Du har tastes: " + inputID + ". Det er ikke et tal. Prøv igen: ");// + nfe.getMessage()
                        }
                        member = getter.getMemberByMemberID(memberID, junior, senior);
                        if (member == null) {
                            System.out.println("Medlem med ID: " + memberID + " kunne ikke findes, prøv igen:");
                        }

                    }

                    System.out.println("Giv indbetalt beløb: og tryk på enter:");

                    while (amount == 0) {
                        String amountInput = in.nextLine();
                        try {
                            amount = Double.parseDouble(amountInput);

                        } catch (NumberFormatException nfe) {
                            System.out.println("Du har tastes: " + amountInput + ". Det er ikke et tal. Prøv igen: ");// + nfe.getMessage()

                        }

                        try {
                            newPayment.registerPayment(member, amount);
                        } catch (SQLException | ClassNotFoundException ex) {
                            Logger.getLogger(CashierIF.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
                break;
                case 2: {
                    balance.showBalance(junior, senior);
                }
                break;
                case 3: {
                    debt.showDabtListe(junior, senior);
                }
                break;
                case 4: {
                    facture.sendYearlyBills(junior, senior);
                    System.out.println("Saldo på hver medlem er formindsket med passende årlig kontingent.\n\n ");

                }
                break;
                case 5: {
                    String answer = "abc";
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
