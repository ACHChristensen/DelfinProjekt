package delfinswimmingclub.Model;

public class Member {

    private String firstName;
    private String surName;
    private double balance;
    private int age;

    private String swimmerType;
    private boolean activ;
    private int memberID;

    public Member(String firstName, String surName, double balance, int age, String swimmerType, int memberID, 
            boolean activ) {
        this.firstName = firstName;
        this.surName = surName;
        this.balance = balance;
        this.age = age;
        this.swimmerType = swimmerType;
        this.memberID = memberID;
        this.activ = activ;
    }

    public void setSwimmerType(String swimmerType) {
        this.swimmerType = swimmerType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public String getSwimmerType() {
        return swimmerType;
    }

    public boolean isActiv() {
        return activ;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setActiv(boolean activ) {
        this.activ = activ;
    }

    @Override
    public String toString() {

        String status;
        if (activ == true) {
            status = "activ";
        }else {
            
        status = "pasiv";}
        return firstName + " " + surName + "\nMedlemID: " + memberID + "\n" + status + " " + swimmerType +
        "\nKontingent: " + balance * (-1) + " DKK/år";
    }

    public boolean getName() {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
