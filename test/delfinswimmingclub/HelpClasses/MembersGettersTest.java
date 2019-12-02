/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinswimmingclub.HelpClasses;

import delfinswimmingclub.Model.AgeTeam;
import delfinswimmingclub.Model.Member;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Magdalena
 */
public class MembersGettersTest {
    
    public MembersGettersTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getMemberByMemberID method, of class MembersGetters.
     */
    @Test
    public void testGetMemberByMemberID() {
        ArrayList juniorList = new ArrayList();
        ArrayList seniorList = new ArrayList();
        Member testMember1 = new Member("Tina", "Mikkelsen", 500, 15, "konkurrencesvømmer", 10, true );
        Member testMember2 = new Member("Luckas", "Skywalker", 1800, 25, "motionsvømmer", 11, false );
        AgeTeam junior = new AgeTeam("juniors", juniorList);
        AgeTeam senior = new AgeTeam("seniors", seniorList); 
        junior.addMember(testMember1);
        senior.addMember(testMember2);
        System.out.println("getMemberByMemberID");
        int id = 11;
       
        MembersGetters instance = new MembersGetters();
        Member expResult = testMember2;
        Member result = instance.getMemberByMemberID(id, junior, senior);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
