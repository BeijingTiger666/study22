package com.study.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@WebService
public interface WeatherServer {

    @WebMethod
//    @WebResult(name="getWeather")
    @Produces(MediaType.APPLICATION_XML)
    @Path(value = "/shanghai")
    public String getWeather();
}

