package delfinswimmingclub;

import delfinswimmingclub.Controller.Controller;
import delfinswimmingclub.EmployeeModel.Cashier.CashierIF;
import delfinswimmingclub.EmployeeModel.Employee;
import delfinswimmingclub.EmployeeModel.EmployeeInterface;
import delfinswimmingclub.EmployeeModel.Manager.ManagerIF;
import delfinswimmingclub.EmployeeModel.Manager.RegisterMember;
import delfinswimmingclub.EmployeeModel.Trainer.TrainerIF;
import delfinswimmingclub.Model.AgeTeam;
import delfinswimmingclub.Model.Member;
import delfinswimmingclub.Trainings.TrainingResult;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Magdalena
 */
public class DelfinSwimmingClub {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Controller controller = new Controller();
        controller.programStart();
        
        // TODO code application logic here
        /*RegisterMember registerMember = new RegisterMember();

        ArrayList<Member> juniorList = new ArrayList();
        ArrayList<Member> seniorList = new ArrayList();

        Member testMember1 = new Member("Tina", "Mikkelsen", 500, 15, "konkurrencesvømmer", 10, true);
        Member testMember2 = new Member("Luckas", "Skywalker", 1800, 25, "motionsvømmer", 11, false);
        Member testMember3 = new Member("Magdalena", "Skov", -100, 35, "konkurrencesvømmer", 13, true);
        Member testMember4 = new Member("Anja", "Rasmussen", 200, 65, "konkurrencesvømmer", 14, true);
        Member testMember5 = new Member("Mikkel", "Vester", -500, 12, "konkurrencesvømmer", 15, false);
        Member testMember6 = new Member("Thomas", "Devine", -3600, 38, "motionsvømmer", 16, false);

        AgeTeam juniors = new AgeTeam("juniors", juniorList);

        AgeTeam seniors = new AgeTeam("seniors", seniorList);        
       
        //Manager 
        /*Employee manager = new Employee("Formand", "Sebastian Bach", "abcd1234" );
        EmployeeInterface managerIF =new ManagerIF();*/
        /*
        seniors.addMember(testMember2);
        seniors.addMember(testMember3);
        seniors.addMember(testMember4);
        seniors.addMember(testMember6);
        juniors.addMember(testMember1);
       
        juniors.addMember(testMember5);

        //Manager 
        Employee manager = new Employee("Formand", "Sebastian Bach", "abcd1234");
        EmployeeInterface managerIF = new ManagerIF();
        managerIF.showMenu(manager, juniors, seniors);

        //Trainer:
        Employee trainer = new Employee("Træner", "Ludwig Poulsen", "10hi");
        EmployeeInterface trainerIF = new TrainerIF();
       // trainerIF.showMenu(trainer, juniors, seniors);

        //Cashier
        Employee cashier = new Employee("Kasserer", "Trine Jensen", "abcd1234");
        EmployeeInterface cashierIF = new CashierIF();
        //cashierIF.showMenu(cashier, juniors, seniors);
 */
    }

}
