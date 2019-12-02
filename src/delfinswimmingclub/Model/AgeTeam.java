package delfinswimmingclub.Model;


import java.util.ArrayList;

public class AgeTeam {

    private String name;
    private ArrayList<Member> team;

    public AgeTeam(String name, ArrayList<Member> team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Member> getTeam() {
        return team;
    }

    @Override
    public String toString() {
         String result = "";
        for (Member member : team) {
            result += member.toString()+ "\n";
        }
        return getName() + ": \n" + result;
    }
    
    public void addMember(Member member){
        team.add(member);
    }
    


}

