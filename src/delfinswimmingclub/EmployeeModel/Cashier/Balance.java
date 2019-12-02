
package delfinswimmingclub.EmployeeModel.Cashier;

import delfinswimmingclub.Model.AgeTeam;
import delfinswimmingclub.Model.Member;

/**
 *
 * @author Magdalena
 */
public class Balance {

    public Balance() {
    }
    
    
    public void showBalance(AgeTeam juniors, AgeTeam seniors) {
        System.out.println("Listen over medlemmernes saldo:\n");
        for (Member m: juniors.getTeam()){
            System.out.println(m.getFirstName() + " " + m.getSurName() + " (MedlemID: " 
                    + m.getMemberID() + ")\t Saldo: " + m.getBalance() );
        }
        for (Member m: seniors.getTeam()){
            System.out.println(m.getFirstName() + " " + m.getSurName() + " (MedlemID: " 
                    + m.getMemberID() + ")\t Saldo: " + m.getBalance() );
        }
    }
}
