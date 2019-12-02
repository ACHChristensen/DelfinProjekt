/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinswimmingclub.EmployeeModel;

import delfinswimmingclub.Model.AgeTeam;
import java.util.ArrayList;

/**
 *
 * @author Magdalena
 */
public interface EmployeeInterface {
    void options();
    void loggIn();
    void loggOut();
    void showMenu(Employee employee, AgeTeam junior, AgeTeam senior);
    
}
