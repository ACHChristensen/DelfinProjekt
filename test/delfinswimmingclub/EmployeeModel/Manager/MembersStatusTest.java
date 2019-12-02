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
public class MembersStatusTest {
    Member member = new Member("Thomas", "Bang", 500, 46, "motionsvømmer", 33, true);
            
    
    public MembersStatusTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of changeActivPasiv method, of class MembersStatus.
     */
    @Test
    public void testChangeActivPasiv() {
        System.out.println("changeActivPasiv");
        
        MembersStatus instance = new MembersStatus();
        instance.changeActivPasiv(member);
        boolean expecteds = false;
        boolean actuals = member.isActiv();
        assertEquals(expecteds, actuals);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
