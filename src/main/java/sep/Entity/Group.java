package sep.Entity;

import java.io.File;
import java.util.*;

public class Group {
    private int groupId;
    private double totalscore=-1;
    private String coursename;
    private Map<String, String> submitpath=new HashMap<String, String>();  // homework name - submitted path
    // stuId-contribution, use softmax to calc
    private Map<Integer, Double> contrib=new HashMap<Integer, Double>();
    private Set<Integer> stulist=new HashSet<Integer>();
    // homework name - score
    private Map<String, Double> score=new HashMap<String, Double>();

    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public double getTotalScore() {
        return totalscore;
    }
    public void setTotalScore(double totalscore) {
        this.totalscore = totalscore;
    }


    public Map<Integer, Double> getContrib() {
        return contrib;
    }
    public void setContrib(Map<Integer, Double> contrib) {
        this.contrib = contrib;
    }
    public double getStuContrib(int stuId){
        if(contrib.containsKey(stuId))
            return contrib.get(stuId);
        else
            return 0.0;
    }
    public void setStuContrib(int stuId, double con){
        contrib.put(stuId, con);
    }


    public Map<String, String> getSubmitpath() {
        return submitpath;
    }
    public void setSubmitpath(Map<String, String> submitpath) {
        this.submitpath = submitpath;
    }
    public String getPathByName(String name){
        return submitpath.get(name);
    }
    public boolean containSubmit(String name){  // check homework is submitted or not
        return submitpath.containsKey(name);
    }
    public int getSubmitNum(){
        return submitpath.size();
    }
    public void addSubmit(String name, String path){    // add & modify
        submitpath.put(name,path);
    }
    public void removeSubmit(String name){
        submitpath.remove(name);
    }


    public Set<Integer> getStulist() {
        return stulist;
    }
    public void setStulist(Set<Integer> stulist) {
        this.stulist = stulist;
    }
    public boolean containStu(int stuId){
        return stulist.contains(stuId);
    }
    public int getStuNum(){
        return stulist.size();
    }
    public void addStu(int stuId){
        stulist.add(stuId);
        contrib.put(stuId,0.0);
    }
    public void removeStu(int stuId){
        if(stulist.contains(stuId)) {
            stulist.remove(stuId);
        }
        if(contrib.containsKey(stuId)){
            contrib.remove(stuId);
        }
    }


    public Map<String, Double> getScore() {
        return score;
    }
    public void setScore(Map<String, Double> score) {
        this.score = score;
    }
    public double getScoreByHname(String hname){
        return score.get(hname);
    }
    public int getScoreNum(){
        return score.size();
    }
    public void addScore(String hname, Double subscore){
        score.put(hname,subscore);
    }


    public String getCoursename() {
        return coursename;
    }
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }


}
