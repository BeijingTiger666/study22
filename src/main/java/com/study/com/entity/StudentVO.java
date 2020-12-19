package com.study.com.entity;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@XmlRootElement(name="student",namespace = "com.study.com.entity.StudentVO")
@XmlType(propOrder = {"sname","birth","age","sid","score","teachers"})
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
    @XmlElement(name = "laoshi")
    @XmlJavaTypeAdapter(MapAdapter.class)
    @XmlList*/
    @XmlElementWrapper
    @XmlElements(
            @XmlElement(name="teacher", type=Teacher.class)
    )
    private List<Teacher> teachers;

    @XmlTransient
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    @Override
    public String toString() {
        return "StudentVO{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", score=" + score +
                '}';
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
    }
}
