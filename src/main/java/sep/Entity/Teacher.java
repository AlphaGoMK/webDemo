package sep.Entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Teacher {
    private int teacherId;
    private String name;
    private Set<String> courseset=new HashSet<String>();

    public int getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public Set<String> getCourseset() {
        return courseset;
    }
    public void setCourseset(Set<String> courseset) {
        this.courseset = courseset;
    }
    public void clearCourse(){
        courseset.clear();
    }
    public boolean containCourse(String course){
        return courseset.contains(course);
    }
    public int getCourseNum(){
        return courseset.size();
    }
    public void addCourse(String course){
        courseset.add(course);
    }
    public void removeCourse(String course){
        if(courseset.contains(course)) courseset.remove(course);
    }

    @Override
    public int hashCode(){
        return teacherId+name.hashCode()*31;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null||getClass()!=o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if(teacherId!=teacher.teacherId) return false;
        if(name!=null?!name.equals(teacher.name):teacher.name!=null) return false;

        Iterator<String> courseit=courseset.iterator();
        while(courseit.hasNext()){
            String c=courseit.next();
            if(!teacher.courseset.contains(c)) return false;
        }

        return true;
    }


}
