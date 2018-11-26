package sep.Model;

import javafx.util.Pair;
import org.apache.struts2.components.Submit;
import sep.Entity.Course;
import sep.Entity.Group;
import sep.Entity.Homework;
import sep.Entity.Student;

import java.util.*;

public class studentAction {

    public Student getStuById(int stuId){
        // TODO: DAO
        return null;
    }

    public List<String> getRegisteredCourse(int stuId){
        Student tmpstu=getStuById(stuId);
        Set<Integer> cSet=tmpstu.getCourseset();
        Iterator<Integer> it=cSet.iterator();
        List<String> res=new ArrayList<String>();
        while(it.hasNext()){
            int cid=it.next();
            String desc=courseAction.getCourseById(cid).getDescription();
            res.add(desc);

        }

        return res;
    }

    public List<Pair<Date, String>> getSubmitById(int grpId, int courseId){
        Group g=courseAction.getGrpById(courseId,grpId);
        List<Pair<Date, String>> submits=new ArrayList<Pair<Date, String>>();
        Set<String> entry=g.getSubmit().keySet();
        Iterator<String> it=entry.iterator();
        while(it.hasNext()){
            String k=it.next();
            Pair<Date, String> tmp=new Pair<Date, String>(g.getSubmitTimeByName(k), g.getSubmitPathByName(k));
            submits.add(tmp);
        }

        return submits;
    }

    public Pair<Date, String> getSubmitByHome(int grpId, int courseId, String home){
        if(!courseAction.getGrpById(courseId, grpId).containSubmit(home)) return null;
        Pair<Date, String> res=new Pair<Date, String>(courseAction.getGrpById(courseId, grpId).getSubmitTimeByName(home),
                courseAction.getGrpById(courseId, grpId).getSubmitPathByName(home));
        return res;
    }

    public void addStuToGroup(int stuId, int courseId, int groupId){
        Group grp=courseAction.getCourseById(courseId).getGrpById(groupId);
        grp.addStu(stuId);
    }

    public void createGroup(int stuId, int courseId, int groupId, String contact){
        Group grp=new Group();
        grp.setCourseID(courseId);
        grp.setLeaderId(stuId);
        grp.setGroupId(groupId);
        grp.setContact(contact);
        grp.addStu(stuId);
        courseAction.getCourseById(courseId).addGrp(grp);
    }

    public void submitHome(int grpId, int courseId, String hname, String path){
        Group tmp=courseAction.getGrpById(courseId,grpId);
        tmp.addSubmit(hname, path); // current time
    }

    public void setContrib(int grpId, int courseId, Map<Integer, Double> contrib_table){
        Group tmp=courseAction.getGrpById(courseId, grpId);
        tmp.setContrib(contrib_table);
    }

    public void setContrib(int grpId, int courseId, int stuId, double contrib){
        Group tmp=courseAction.getGrpById(courseId, grpId);
        tmp.setStuContrib(stuId, contrib);
    }

    public double calcGrpScore(int grpId, int courseId){
        Group tmp=courseAction.getGrpById(courseId, grpId);
        tmp.calcAvg();
        return tmp.getTotalScore();
    }

    public double calcStuScore(int stuId, int courseId){
        Group grp=null;
        Course cou=courseAction.getCourseById(courseId);
        Set<Group> grplist=cou.getGrp();
        Iterator<Group> it=grplist.iterator();
        while(it.hasNext()){
            Group tmp=it.next();
            if(tmp.containStu(stuId)){
                grp=tmp;
            }
        }
        if(grp==null){
            return -1;
        }
        if(grp.getTotalScore()<0.0) grp.calcAvg();
        return grp.getTotalScore()*grp.getStuContrib(stuId)/100.0;
    }

}
