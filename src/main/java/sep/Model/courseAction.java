package sep.Model;

import sep.Entity.Course;
import sep.Entity.Group;

public class courseAction {

    public static Course getCourseById(int courseId){
        // TODO DAO
        return null;
    }

    public static Group getGrpById(int courseId, int groupId){
        Course c=getCourseById(courseId);
        return c.getGrpById(groupId);
    }
}
