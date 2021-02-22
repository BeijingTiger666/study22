package com.study.ws.ws.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name="teacher",namespace="com.study.ws.ws.entity.Teacher")
public class Teacher implements Serializable {
    @XmlElement(name = "teachername")
    private String teachername;
    @XmlElement(name = "subject")
    private String subject;
    private int id;

    @Override
    public String toString() {
        return "Teacher{" +
                "teachername='" + teachername + '\'' +
                ", subject='" + subject + '\'' +
                ", id=" + id +
                '}';
    }

    @XmlTransient
    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }
    @XmlTransient
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlTransient
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher(String teachername, String subject, int id) {
        this.teachername = teachername;
        this.subject = subject;
        this.id = id;
    }

    public Teacher() {
    }

    public Teacher(String teachername, int id) {
        this.teachername = teachername;
        this.id = id;
    }
}
