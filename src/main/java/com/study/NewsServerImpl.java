package com.study;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;

@Component
@WebService(serviceName = "NewsSer",
//        portName = "WeatherSer",
//        targetNamespace = "http://ws.chinaunicom.cn/DepartmentInfoSer/",
//        wsdlLocation = "classpath:wsdl/SB_SDM_SDM_ImportItemInfoSrv.wsdl",
        endpointInterface= "com.study.NewsServer")
public class NewsServerImpl implements NewsServer {
    @WebMethod
    @Override
    public String getNews(@WebParam(name="province")String province) {
        return province+"--美国由于新冠疫情已几于崩溃边缘,各国警惕美国以发动战争转移国内矛盾";
    }

}

