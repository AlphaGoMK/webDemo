package sep.Model;

import sep.Entity.Course;
import sep.Entity.Group;

public class courseAction {

    public static Course getCourseById(int courseId){
        // TODO DAO
        return null;
    }

    public static Group getGrpById(int courseId, String groupId){
        Course c=getCourseById(courseId);
        return c.getGrpById(groupId);
    }

    public static void setCourse(int name, int id, String desc, int teacherId){
        // TODO DAO
        return null;
    }

    public void setGrpCfg(int courseId, String prefix, int maxcrew, int mincrew){
        Course c=getCourseById(courseId);
        c.setGrpPrefix(prefix);
        c.setMaxCrew(maxcrew);
        c.setMinCrew(mincrew);
    } 
}
