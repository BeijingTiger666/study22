package com.study.ws.vo;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "st_body",namespace = "com.study.ws.vo.ST_BODY")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "st_body",namespace = "com.study.ws.vo.ST_BODY")
public class ST_BODY {
    @XmlElement(name = "OPERATE_TYPE", required = true)
    protected String operateTYPE;
    @XmlElement(name = "RES_CODE", required = true)
    protected String resCODE;
    @XmlElement(name = "RES_NAME", required = true)
    protected String resNAME;

    public ST_BODY() {
    }
    @XmlTransient
    public String getOperateTYPE() {
        return operateTYPE;
    }

    public void setOperateTYPE(String operateTYPE) {
        this.operateTYPE = operateTYPE;
    }
    @XmlTransient
    public String getResCODE() {
        return resCODE;
    }

    public void setResCODE(String resCODE) {
        this.resCODE = resCODE;
    }
    @XmlTransient
    public String getResNAME() {
        return resNAME;
    }

    public void setResNAME(String resNAME) {
        this.resNAME = resNAME;
    }

    public ST_BODY(String operateTYPE, String resCODE, String resNAME) {
        this.operateTYPE = operateTYPE;
        this.resCODE = resCODE;
        this.resNAME = resNAME;
    }
}
