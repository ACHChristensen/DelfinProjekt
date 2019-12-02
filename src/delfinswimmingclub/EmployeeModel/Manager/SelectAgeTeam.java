/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinswimmingclub.EmployeeModel.Manager;

import delfinswimmingclub.Model.AgeTeam;
import delfinswimmingclub.Model.Member;
import java.util.ArrayList;

/**
 *
 * @author Magdalena
 */
public class SelectAgeTeam {

    public SelectAgeTeam() {
    }

    public void selectTeamByAge(Member member, AgeTeam junior, AgeTeam senior) {
        if (member.getAge() < 18) {
            junior.addMember(member);

        } else {
            senior.addMember(member);
        }

    }

}
