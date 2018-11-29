package sep.Action;

import com.opensymphony.xwork2.ActionSupport;
import sep.Entity.Homework;
import sep.Model.courseOps;

// rank group homework
public class ScoreHomeAction extends ActionSupport {
    private double score;

    private int courseId;
    private Homework homework;
    private String grpid;
    private courseOps courseaction=new courseOps();

    @Override
    public String execute() throws Exception{
        courseaction.getGrpById(courseId, grpid).addScore(getHomeworkname(), score);
        return SUCCESS;
    }

    public String getHomeworkname(){
        return homework.getName();
    }

}
