/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinswimmingclub.EmployeeModel.Manager;

import delfinswimmingclub.DatabBase.MemberIDFromDB;
import delfinswimmingclub.DatabBase.MemberToSQL;
import delfinswimmingclub.DatabBase.SetMemberID;
import delfinswimmingclub.Model.Member;
import delfinswimmingclub.EmployeeModel.Cashier.Subscription;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Magdalena
 */
public class RegisterMember {

    Scanner in = new Scanner(System.in);
    MemberToSQL memberToSQL = new MemberToSQL();
    MemberIDFromDB memberIDFromDB = new MemberIDFromDB();

    public RegisterMember() {
    }

    public Member newMember() throws ClassNotFoundException, SQLException {
        SetMemberID setID = new SetMemberID();
        Member member = null;
        Subscription payment = new Subscription();
        //int memberID = 0;// setID.updateMemberID() + 1;//læser den storste MemberID i DB

        boolean activ = false;
        String firstName;
        String surName;
        String swimmerType = "";
        int age = 0;

        System.out.println("Registering af en ny medlem: \n");

        System.out.print("Giv fornavn: ");
        firstName = in.nextLine();

        System.out.println("Fornavn gemt som: " + firstName);

        System.out.print("Giv efternavn: ");
        surName = in.nextLine();

        System.out.println("Efternavn gent som: " + surName);

        System.out.println("Giv alder: ");
        while ( age==0){
        String ageInput = in.nextLine();

        try {
            age = Integer.parseInt(ageInput);
            System.out.println("Alder gemt som : " + age);
        } catch (NumberFormatException nfe) {
            System.out.println("Du har tastes: " + ageInput + ". Det er ikke et tal. Prøv igen: " );// + nfe.getMessage()
            
        }
        }

        int inputType;
        boolean quit = false;
        while (quit == false) {
            System.out.println("Er medlem en konkurrencesvømmer? (Tryk 1 for \"ja\""
                    + " eller enhver tal for \"nej\" og \"Enter\" bagefter:");
            try {
                in = new Scanner(System.in);
                inputType = in.nextInt();
                in.nextLine();
                if (inputType == 1) {
                    swimmerType = "konkurrencesvømmer";
                    System.out.println("Medlem er en konkurrencesvømmer");
                    quit = true;
                } else if (inputType != 1) {
                    swimmerType = "motionsvømmer";
                    System.out.println("Medlem er ikke en konkurrencesvømmer");
                    quit = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Det var ikke et tal. Prøv igen");
            }
        }

        boolean finish = false;
        while (finish == false) {
            System.out.println("Er medlem en aktivsvømmer? (Tryk 1 for \"ja\""
                    + " eller enhver tal for \"nej\" og \"Enter\" bagefter: ");
            try {
                in = new Scanner(System.in);
                int inputActiv = in.nextInt();
                if (inputActiv == 1) {
                    activ = true;
                    System.out.println("Medlem er AKTIV");
                    finish = true;
                } else if (inputActiv != 1) {
                    activ = true;
                    System.out.println("Medlem er PASSIV");
                    finish = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Det var ikke et tal. Prøv igen");
            }
        }
        
         double price = payment.calculateMembershipsPrice(age,activ);
        int memberID = memberIDFromDB.GetMemberIDFromDB(firstName,surName);
        member = new Member(firstName, surName, price*(-1), age, swimmerType, memberID, activ);
        memberToSQL.sendMemberToDB(member);

        System.out.println(
                "Medlem er " + age + " år gammel, derfor skal betale kontingent på " + price);

        return member;

    }
}
