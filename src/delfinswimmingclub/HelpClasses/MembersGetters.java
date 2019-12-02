/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinswimmingclub.HelpClasses;

import delfinswimmingclub.Model.AgeTeam;
import delfinswimmingclub.Model.Member;
import java.util.ArrayList;

/**
 *
 * @author Magdalena
 */
public class MembersGetters {

    public MembersGetters() {
    }

    public Member getMemberByMemberID(int id, AgeTeam junior, AgeTeam senior) {
        Member searchedMember = null;
        for (Member juniorMember : junior.getTeam()) {
            if (id == juniorMember.getMemberID()) {
                searchedMember = juniorMember;
            }
        }
        for (Member seniorMember : senior.getTeam()) {
            if (id == seniorMember.getMemberID()) {
                searchedMember = seniorMember;
            }
        }

        return searchedMember;

    }
}
