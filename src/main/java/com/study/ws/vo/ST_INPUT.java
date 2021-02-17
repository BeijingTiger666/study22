package com.study.ws.vo;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "st_input",namespace = "com.study.ws.vo.ST_INPUT")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ST_HEAD.class,ST_BODY.class})
@XmlType(name = "st_input",namespace = "com.study.ws.vo.ST_INPUT")

public class ST_INPUT implements Serializable {

    @XmlElement(name = "ST_HEAD", required = true)
    protected ST_HEAD stHEAD;
    @XmlElement(name = "ST_BODY")
    protected ST_BODY stBODY;

    public ST_INPUT() {
    }

    public ST_INPUT(ST_HEAD stHEAD, ST_BODY stBODY) {
        this.stHEAD = stHEAD;
        this.stBODY = stBODY;
    }
    @XmlTransient
    public ST_HEAD getStHEAD() {
        return stHEAD;
    }

    public void setStHEAD(ST_HEAD stHEAD) {
        this.stHEAD = stHEAD;
    }
    @XmlTransient
    public ST_BODY getStBODY() {
        return stBODY;
    }

    public void setStBODY(ST_BODY stBODY) {
        this.stBODY = stBODY;
    }

    @Override
    public String toString() {
        return "ST_INPUT{" +
                "stHEAD=" + stHEAD +
                ", stBODY=" + stBODY +
                '}';
    }
}
