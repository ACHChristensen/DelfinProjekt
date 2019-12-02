
package delfinswimmingclub.EmployeeModel.Cashier;

import delfinswimmingclub.Model.AgeTeam;
import delfinswimmingclub.Model.Member;

/**
 *
 * @author Magdalena
 */
public class Debt {

    public Debt() {
    }
    //TODO opdatere DB med medlemmer, hvis balance er på minus
    
    public void showDabtListe(AgeTeam junior, AgeTeam senior){
        System.out.println("Listem over medlemmer på restance: \n");
        for (Member m: junior.getTeam()){
            if(m.getBalance()<0){
                
                System.out.println(m.getFirstName() + " " + m.getSurName() 
                        +" MemberID: " + m.getMemberID()+ "\nbalance: " + m.getBalance()+"\n");
            }
        }
        for (Member m: senior.getTeam()){
             if(m.getBalance()<0){
                
                System.out.println(m.getFirstName() + " " + m.getSurName() 
                        +" MemberID: " + m.getMemberID()+ "\nbalance: " + m.getBalance()+"\n");
            }
        }
        
    }
}
