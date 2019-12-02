/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinswimmingclub.EmployeeModel.Cashier;

import delfinswimmingclub.Model.Member;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Magdalena
 */
public class DebtTest {

    public DebtTest() {
    }
    ArrayList<Member> junior = new ArrayList();
    ArrayList<Member> senior = new ArrayList();
    ArrayList<Member> debt = new ArrayList();
    Member testMember1 = new Member("Tina", "Mikkelsen", 500, 15, "konkurrencesvømmer", 11, true);
    Member testMember2 = new Member("Luckas", "Skywalker", 1800, 25, "motionsvømmer", 12, false);
    Member testMember3 = new Member("Magdalena", "Skov", -100, 35, "konkurrencesvømmer", 13, true);
    Member testMember4 = new Member("Anja", "Rasmussen", 200, 65, "konkurrencesvømmer", 14, true);
    Member testMember5 = new Member("Mikkel", "Vester", -500, 12, "konkurrencesvømmer", 15, false);
    Member testMember6 = new Member("Thomas", "Devine", -3600, 38, "motionsvømmer", 16, false);

    @Before
    public void setUp() {
        junior.add(testMember1);
        junior.add(testMember5);
        senior.add(testMember2);
        senior.add(testMember3);
        senior.add(testMember4);
        senior.add(testMember6);

        for (Member m : junior) {
            if (m.getBalance() < 0) {

                debt.add(m);
            }
        }
        for (Member m : senior) {
            if (m.getBalance() < 0) {

               debt.add(m);
            }
        }
    }
        /**
         * Test of showDabtListe method, of class Debt.
         */
        @Test
        public void testShowDabtListe () {
        System.out.println("showDabtListe");
        boolean expected=true;
        boolean actual=debt.contains(testMember6);
            assertEquals(expected, actual);

           }

    }
    /*
ArrayList<Member> juniorList = new ArrayList();
        ArrayList<Member> seniorList = new ArrayList();
        
        Member testMember1 = new Member("Tina", "Mikkelsen", 500, 15, "konkurrencesvømmer", 10, true );
        Member testMember2 = new Member("Luckas", "Skywalker", 1800, 25, "motionsvømmer", 11, false );
               
        AgeTeam juniors = new AgeTeam("juniors", juniorList);
        AgeTeam seniors = new AgeTeam("seniors", seniorList);
     */
