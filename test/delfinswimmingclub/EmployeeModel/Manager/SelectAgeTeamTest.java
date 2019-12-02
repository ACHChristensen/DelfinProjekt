/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinswimmingclub.EmployeeModel.Manager;

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
public class SelectAgeTeamTest {
    Member member = new Member("Thomas", "Bang", 500, 46, "motionsvømmer", 33, true);
    public SelectAgeTeamTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of selectTeamByAge method, of class SelectAgeTeam.
     */
    @Test
    public void testSelectTeamByAge() {
        System.out.println("selectTeamByAge");
       ArrayList<Member> juniors = new ArrayList<>();
       ArrayList<Member> seniors = new ArrayList<>();

        AgeTeam junior = new AgeTeam("UngdomsHold", juniors);
        AgeTeam senior = new AgeTeam("SeniorsHold", seniors);
        SelectAgeTeam instance = new SelectAgeTeam();
        instance.selectTeamByAge(member, junior, senior);
        boolean expected = true;
        boolean result = senior.getTeam().contains(member);
        assertEquals(expected, result);
    }
    
}
