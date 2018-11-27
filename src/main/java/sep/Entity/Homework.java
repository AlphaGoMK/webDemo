package sep.Entity;

import java.util.Date;

public class Homework {
    private String name;
    private int courseid;
    private String content;
    private Date assigntime;
    private Date deadline;
    private double percentage;

    public Homework(String name, int courseid, String content, Date deadline, double percentage){
        this.name=name;
        this.courseid=courseid;
        this.content=content;
        this.assigntime=new Date();
        this.deadline=deadline;
        this.percentage=percentage;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAssigntime() {
        return assigntime;
    }

    public void setAssigntime(Date assigntime) {
        this.assigntime = assigntime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
