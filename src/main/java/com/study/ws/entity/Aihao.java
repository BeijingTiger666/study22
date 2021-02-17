package com.study.ws.entity;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "aihao",namespace = "com.study.ws.entity.Aihao")
@XmlAccessorType(XmlAccessType.FIELD)
public class Aihao implements Serializable {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "aname")
    private String aname;

    @Override
    public String toString() {
        return "Aihao{" +
                "id=" + id +
                ", aname='" + aname + '\'' +
                '}';
    }
    @XmlTransient
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlTransient
    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Aihao() {
    }

    public Aihao(int id, String aname) {
        this.id = id;
        this.aname = aname;
    }
}
