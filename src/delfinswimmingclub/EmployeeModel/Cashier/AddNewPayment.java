/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinswimmingclub.EmployeeModel.Cashier;

import delfinswimmingclub.Model.Member;
import delfinswimmingclub.Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Magdalena
 */
public class AddNewPayment {

    public AddNewPayment() {
    }

    //resgistrering af en ny betaling for en medlem - sender betalinge til databasen og opdaterer saldo(balance) på medlemen
    public void registerPayment(Member member, double amount) throws SQLException, ClassNotFoundException {
        double actlBalance = member.getBalance();
        member.setBalance(actlBalance + amount);

        Connection myConnector = null;
        myConnector = DBConnector.getConnection();
        PreparedStatement pstmt = null;
        String query = "INSERT INTO delfindb.payment (MemberID, Amount, Date, Balance) VALUES (\""
                + member.getMemberID() + "\", \"" + amount + "\", " + " NOW(), +" + member.getBalance() + ")";

        String queryUpdateBalance = "UPDATE delfindb.members Balance" + member.getBalance()
                + " WHERE delfindb.members.MemberID = " + member.getMemberID();

        pstmt = myConnector.prepareStatement(query);
        pstmt.executeUpdate(query);

        pstmt.close();
        myConnector.close();

    }

}
