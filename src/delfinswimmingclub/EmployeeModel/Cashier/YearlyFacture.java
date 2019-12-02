
package delfinswimmingclub.EmployeeModel.Cashier;

import delfinswimmingclub.Model.AgeTeam;
import delfinswimmingclub.Model.Member;

/**
 *
 * @author Magdalena
 */
public class YearlyFacture {

    public void sendYearlyBills(AgeTeam junior, AgeTeam senior) {
        Subscription price = new Subscription();
        for (Member m : junior.getTeam()) {
            double balance = m.getBalance();
            m.setBalance(balance - price.calculateMembershipsPrice(m.getAge(), m.isActiv()));

        }
        for (Member m : senior.getTeam()) {
            double balance = m.getBalance();
            m.setBalance(balance - price.calculateMembershipsPrice(m.getAge(), m.isActiv()));
        }

    }

}
