/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinswimmingclub.EmployeeModel.Cashier;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Magdalena
 */
public class SubscriptionTest {
    
    public SubscriptionTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of calculateMembershipsPrice method, of class Subscription.
     */
    @Test
    public void testCalculateMembershipsPrice() {
        System.out.println("calculateMembershipsPrice");
        int age = 15;
        boolean activ = true;
        Subscription instance = new Subscription();
        double expResult = 1000.0;
        double result = instance.calculateMembershipsPrice(age, activ);
        assertEquals(expResult, result, 0.0);
        
    }
    
}
