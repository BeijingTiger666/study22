package com.study;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface NewsServer {

    @WebMethod
//    @WebResult(name="getWeather")
    public String getNews(@WebParam(name = "province") String province);
}

