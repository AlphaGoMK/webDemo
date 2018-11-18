package sep.Entity;

import javax.persistence.Entity;
import java.util.*;

import static java.lang.Math.abs;

@Entity
public class Student {
    private int stuId;
    private String name;
    private double score;
    private String classid;
    // course - groupId
    private Map<String, Integer> groupmap=new HashMap<String, Integer>();
    private Set<String> courseset=new HashSet<String>();


    public int getStuId(){
        return stuId;
    }
    public void setStuId(int stuId){
        this.stuId=stuId;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public double getScore(){
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

    public String getClassid() {
        return classid;
    }
    public void setClassid(String classid) {
        this.classid = classid;
    }


    public Map<String, Integer> getGroupmap(){
        return groupmap;
    }
    public void setGroupmap(Map<String, Integer> groupmap){
        this.groupmap=groupmap;
    }
    public void clearGroupmap(){
        groupmap.clear();
    }
    public int getGroupId(String course){
        if(groupmap.containsKey(course)) return groupmap.get(course);
        else return -1;
    }
    public void setGroupId(String course, int Id){
        groupmap.put(course, Id);
    }


    public Set<String> getCourseset(){
        return courseset;
    }
    public void setCourseset(Set<String> courseset){
        this.courseset=courseset;
    }
    public void clearCourseset(){
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
        if(groupmap.containsKey(course)) groupmap.remove(course);
    }

    @Override
    public int hashCode(){
        return stuId+name.hashCode()*31;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null||getClass()!=o.getClass()) return false;

        Student student = (Student) o;

        if(stuId!=student.stuId) return false;
        if(name!=null?!name.equals(student.name):student.name!=null) return false;
        if(abs(score-student.score)>1e-4) return false;
        if(classid!=null?!classid.equals(student.classid):student.classid!=null) return false;

        Set<String> keySet=groupmap.keySet();
        Set<String> stuKeySet=student.groupmap.keySet();
        if(keySet.size()!=stuKeySet.size()) return false;
        Iterator<String> it=keySet.iterator();
        while(it.hasNext()){
            String key=it.next();
            if(groupmap.get(key).equals(student.groupmap.get(key))) return false;
        }

        Iterator<String> courseit=courseset.iterator();
        while(courseit.hasNext()){
            String c=courseit.next();
            if(!student.courseset.contains(c)) return false;
        }

        return true;
    }

}
