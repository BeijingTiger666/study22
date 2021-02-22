package com.study.ws.ws.entity;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@XmlRootElement(name="student",namespace = "com.study.ws.ws.entity.StudentVO")
@XmlType(propOrder = {"sname","birth","age","sid","score","teachers","aihao"})
@XmlSeeAlso({Aihao.class})
public class StudentVO  implements Serializable {
    @XmlElement(name = "id")
    private int sid;
    @XmlElement(name = "name")
    private String sname;
    @XmlElement(name = "age")
    private int age;
    @XmlElement(name = "birthday")
    private Date birth;
    @XmlElement(name = "score")
    private int score;
    /*学习过程中的产物
    @XmlList*/
    @XmlElementWrapper
    @XmlElements(
            @XmlElement(name="teacher", type=Teacher.class)
    )
    private List<Teacher> teachers;
    @XmlElement(name = "aihao")
    private HashMap<String,Aihao> aihao;

    @XmlTransient
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    @XmlTransient
    public HashMap<String, Aihao> getAihao() {
        return aihao;
    }
    public void setAihao( HashMap<String, Aihao> aihao) {
        this.aihao = aihao;
    }

    @XmlTransient
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @XmlTransient
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
    @XmlTransient
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
    @XmlTransient
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentVO() {
    }
    @XmlTransient
    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public StudentVO(int sid, String sname, int age) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
    }

    public StudentVO(int sid, String sname, int age, Date birth) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.birth = birth;
    }

    public StudentVO(int sid, String sname, int age, Date birth, int score) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.birth = birth;
        this.score = score;
    }

    public StudentVO(int sid, String sname, int age, Date birth, int score, List<Teacher> teachers) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.birth = birth;
        this.score = score;
        this.teachers = teachers;
    }    @Override
    public String toString() {
        return "StudentVO{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", score=" + score +
                ", teachers=" + teachers +
                ", aihao=" + aihao +
                '}';
    }

    public StudentVO(int sid, String sname, int age, Date birth, int score, List<Teacher> teachers, HashMap<String, Aihao> aihao) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.birth = birth;
        this.score = score;
        this.teachers = teachers;
        this.aihao = aihao;
    }

}
