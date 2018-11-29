package sep.Action;

import com.opensymphony.xwork2.ActionSupport;
import sep.Model.courseOps;

import java.util.List;

// display unranked group homework
public class CheckHomeAction extends ActionSupport {
    // input
    public int courseId;
    public String grpId;

    // set
    private List<String> unrankedhome;
    private courseOps courseaction=new courseOps();

    @Override
    public String execute() throws Exception{
        unrankedhome=courseaction.getGrpById(courseId, grpId).getUnrankedSubmit();

        return SUCCESS;
    }

    public List<String> getUnrankedhome() {
        return unrankedhome;
    }

    public void setUnrankedhome(List<String> unrankedhome) {
        this.unrankedhome = unrankedhome;
    }
}
