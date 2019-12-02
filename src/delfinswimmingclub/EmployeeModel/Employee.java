package delfinswimmingclub.EmployeeModel;

/**
 *
 * @author Magdalena
 */
public class Employee {

    private String position;
    private String name;
    private String password;

    public Employee(String position, String name, String password) {
        this.position = position;
        this.name = name;
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    

    
}
