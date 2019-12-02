/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinswimmingclub.EmployeeModel.Manager;

import delfinswimmingclub.Model.Member;

/**
 *
 * @author Magdalena
 */
public class ChangeMembersType {

    public ChangeMembersType() {
    }

    public void changeType(Member member) {

        if ("konkurrencesvømmer".equals(member.getSwimmerType())) {
            member.setSwimmerType("motionsvømmer");
        }
        member.setSwimmerType("konkurrencesvømmer");
    }
}
