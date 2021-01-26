package com.study.com.entity.req;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "st_head",namespace = "com.study.com.entity.req.ST_HEAD")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "st_head",namespace = "com.study.com.entity.req.ST_HEAD")

public class ST_HEAD {
    @XmlElement(name = "ORIG_DOMAIN", required = true)
    protected String origDOMAIN;
    @XmlElement(name = "SERVICE_NAME", required = true)
    protected String serviceNAME;
    @XmlElement(name = "OPERATE_NAME", required = true)
    protected String operateNAME;
    @XmlTransient
    public String getOrigDOMAIN() {
        return origDOMAIN;
    }

    public void setOrigDOMAIN(String origDOMAIN) {
        this.origDOMAIN = origDOMAIN;
    }
    @XmlTransient
    public String getServiceNAME() {
        return serviceNAME;
    }

    public void setServiceNAME(String serviceNAME) {
        this.serviceNAME = serviceNAME;
    }
    @XmlTransient
    public String getOperateNAME() {
        return operateNAME;
    }

    public void setOperateNAME(String operateNAME) {
        this.operateNAME = operateNAME;
    }

    public ST_HEAD(String origDOMAIN, String serviceNAME, String operateNAME) {
        this.origDOMAIN = origDOMAIN;
        this.serviceNAME = serviceNAME;
        this.operateNAME = operateNAME;
    }

    public ST_HEAD() {
    }
}
