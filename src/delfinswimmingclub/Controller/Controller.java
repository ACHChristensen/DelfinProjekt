package delfinswimmingclub.Controller;

import delfinswimmingclub.EmployeeModel.Cashier.CashierIF;
import delfinswimmingclub.EmployeeModel.Employee;
import delfinswimmingclub.EmployeeModel.EmployeeInterface;
import delfinswimmingclub.EmployeeModel.Manager.ManagerIF;
import delfinswimmingclub.EmployeeModel.Trainer.TrainerIF;
import delfinswimmingclub.Model.AgeTeam;
import delfinswimmingclub.Model.Member;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    ArrayList<Member> juniorList = new ArrayList();
    ArrayList<Member> seniorList = new ArrayList();
    TrainerIF trainerIF = new TrainerIF();
    AgeTeam juniors = new AgeTeam("juniors", juniorList);
    AgeTeam seniors = new AgeTeam("seniors", seniorList);
    Scanner myScan = new Scanner(System.in);

    public Controller() {
    }

    public void programStart() {
        boolean quit = false;
        while(quit==false){
        System.out.println("Indtast adgangskode, for at logge in eller tast 0 for at lukke programmet:");
        String password = myScan.nextLine();
        if (password.equals("abcd1234")) {
            managerMenu();
        } else if (password.equals("10hi")) {
            trainerMenu();
        } else if ( password.equals("hejmeddig")) {
            cashierMenu();
        }
        else if ( password.equals("0")) {
            quit = true;
        }
        else {System.out.println("Forkert adgangskode. Prøv igen.");}
        
    }}

    public void managerMenu() {
        Employee manager = new Employee("Formand", "Sebastian Bach", "abcd1234");
        EmployeeInterface managerIF = new ManagerIF();
        managerIF.showMenu(manager, juniors, seniors);
    }

    public void trainerMenu() {
        Employee trainer = new Employee("Træner", "Ludwig Poulsen", "10hi");
        trainerIF.showMenu(trainer, juniors, seniors);
    }

    public void cashierMenu() {
        Employee cashier = new Employee("Kasserer", "Trine Jensen", "hejmeddig");
        EmployeeInterface cashierIF = new CashierIF();
        cashierIF.showMenu(cashier, juniors, seniors);
    }
}
