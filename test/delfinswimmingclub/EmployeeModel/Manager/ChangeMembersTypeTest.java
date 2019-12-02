/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinswimmingclub.EmployeeModel.Manager;

import delfinswimmingclub.Model.Member;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Magdalena
 */
public class ChangeMembersTypeTest {
      Member member = new Member("Thomas", "Bang", 500, 46, "motionsvømmer", 33, true);
    public ChangeMembersTypeTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of changeType method, of class ChangeMembersType.
     */
    @Test
    public void testChangeType() {
        System.out.println("changeType");
      
        ChangeMembersType instance = new ChangeMembersType();
        instance.changeType(member);
        String expected = "konkurrencesvømmer";
        String result = member.getSwimmerType();
        assertEquals(expected, result);
    }
    
}
