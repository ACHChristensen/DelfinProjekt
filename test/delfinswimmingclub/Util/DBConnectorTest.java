/*
 * Magdalena Wawrzak
 */
package delfinswimmingclub.Util;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruger
 */
public class DBConnectorTest {
    
    public DBConnectorTest() {
    }

    /**
     * Test of getConnection method, of class DBConnector.
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        Connection expResult = null;
        Connection result = DBConnector.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
