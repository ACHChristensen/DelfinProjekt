package delfinswimmingclub.EmployeeModel.Manager;




import delfinswimmingclub.Model.Member;

/**
 *
 * @author Magdalena
 */
public class MembersStatus {

    public MembersStatus() {
    }
    
    
    public void changeActivPasiv(Member member){
        if (member.isActiv()==true){
            member.setActiv(false);
        }else {
            member.setActiv(true);
        }
               
        
    }
    
}
