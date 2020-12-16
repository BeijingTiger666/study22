package com.study;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface WeatherServer {

    @WebMethod
//    @WebResult(name="getWeather")
    public String getWeather(@WebParam(name="province")String province);
}

