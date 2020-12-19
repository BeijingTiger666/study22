package com.study;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Path;
import java.util.HashMap;

@Component
@WebService(serviceName = "WeatherSer",
//        portName = "WeatherSer",
//        targetNamespace = "http://ws.chinaunicom.cn/DepartmentInfoSer/",
//        wsdlLocation = "classpath:wsdl/SB_SDM_SDM_ImportItemInfoSrv.wsdl",
        endpointInterface= "com.study.WeatherServer")
public class WeatherServerImpl implements WeatherServer {
    @WebMethod
    @Override
    public String getWeather() {
        return ": 明天天气为:大雪";
    }

}

