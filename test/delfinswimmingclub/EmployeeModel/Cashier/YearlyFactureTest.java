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
public class YearlyFactureTest {

    public YearlyFactureTest() {
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

    }

    /**
     * Test of sendYearlyBills method, of class YearlyFacture.
     */
    @Test
    public void testSendYearlyBills() {

        System.out.println("sendYearlyBills");
        Subscription price = new Subscription();
        junior.add(testMember1);
        junior.add(testMember5);
        senior.add(testMember2);
        senior.add(testMember3);
        senior.add(testMember4);
        senior.add(testMember6);
        for (Member m : junior) {
            double balance = m.getBalance();
            m.setBalance(balance - price.calculateMembershipsPrice(m.getAge(), m.isActiv()));

        }
        for (Member m : senior) {
            double balance = m.getBalance();
            m.setBalance(balance - price.calculateMembershipsPrice(m.getAge(), m.isActiv()));
        }

        double expected = -500;
        double actual = testMember1.getBalance();
        assertEquals(expected, actual, 1);

    }

}
