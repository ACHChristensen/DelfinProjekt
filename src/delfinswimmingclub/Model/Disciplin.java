package delfinswimmingclub.Model;

//@author Cathrine
import java.util.ArrayList;

public class Disciplin {

    ArrayList<Member> butMembers;
    ArrayList<Member> craMembers;
    ArrayList<Member> rygMembers;
    ArrayList<Member> bryMembers;

    public Disciplin() {
    }

    public String pickDisciplinNameByDisciplineID(String disciplineID) {
        String disciplineName;
        boolean quit = false;
        while (quit == false) {
            switch (disciplineID) {
                case "but":
                    disciplineName = "butterfly";
                    return disciplineName;
                case "cra":
                    disciplineName = "crawl";
                    return disciplineName;
                case "ryg":
                    disciplineName = "rygcrawl";
                    return disciplineName;
                case "bry":
                    disciplineName = "brystsvømning";
                    return disciplineName;
                case "0":
                String disciplineMessage = "\nButterfly har ID = \t \"but\""
                        + "\nCrawl har ID =\t\t \"cra\" "
                        + "\nRygcrawl her ID =\t \"ryg\""
                        + "\nBrystsvømning her ID =\t \"bry\"";
                    return disciplineMessage;
                default:
                    System.out.println("Dette er ikke en disciplinID");
            }
        }
        return "";
    }

    public ArrayList<Member> addMemberToBut(Member member) {
        butMembers = new ArrayList();
        butMembers.add(member);
        return butMembers;
    }

    public ArrayList<Member> addMemberToCra(Member member) {
        craMembers = new ArrayList();
        craMembers.add(member);
        return craMembers;
    }

    public ArrayList<Member> addMemberToRyg(Member member) {
        rygMembers = new ArrayList();
        rygMembers.add(member);
        return rygMembers;
    }

    public ArrayList<Member> addMemberToBry(Member member) {
        bryMembers = new ArrayList();
        bryMembers.add(member);
        return bryMembers;
    }
}
