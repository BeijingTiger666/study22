package com.study.com.entity.req;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "st_output",namespace = "com.study.com.entity.req.ST_OUTPUT")
@XmlSeeAlso({ST_HEAD.class,ST_BODY.class})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "st_output",namespace = "com.study.com.entity.req.ST_OUTPUT")
public class ST_OUTPUT implements Serializable {

    @XmlElement(name = "ST_HEAD", required = true)
    protected ST_HEAD stHEAD;
    @XmlElement(name = "ST_BODY")
    protected ST_BODY stBODY;

    public ST_OUTPUT() {
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

    public ST_OUTPUT(ST_HEAD stHEAD, ST_BODY stBODY) {
        this.stHEAD = stHEAD;
        this.stBODY = stBODY;
    }
}
