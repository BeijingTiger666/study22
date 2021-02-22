package com.study.ws.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

public class Student implements Serializable {
    private String teachername;
    private String subject;
    private int id;
}
