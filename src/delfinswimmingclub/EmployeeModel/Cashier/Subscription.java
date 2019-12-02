package delfinswimmingclub.EmployeeModel.Cashier;

public class Subscription {

    public double calculateMembershipsPrice(int age, boolean activ) {
        double price;
        if (activ == false) {
            price = 500;

        } else if (age < 18) {
            price = 1000;
        } else if (age >= 60) {
            price = 1350;
        } else if (age >= 18 || age < 60) {
            price = 1800;
        } else {
            price = 1350;
        }

        return price;
    }
}