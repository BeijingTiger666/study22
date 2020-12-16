package com.study;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@Component
@WebService(endpointInterface= "com.study.WeatherServer")
public class MyServerImpl implements WeatherServer {
    @WebMethod
    @Override
    public String getWeather(@WebParam(name="province")String province) {
        System.out.println(province+", 明天的天气为大雪" );
        return "大雪";
    }

}

