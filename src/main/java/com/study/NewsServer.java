package com.study;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@WebService
public interface NewsServer {

    @WebMethod
    @WebResult(name="getWeather")
    @Produces(MediaType.APPLICATION_XML)
    @Path(value = "/shanghai")
    public String getNews(@WebParam(name = "province") String province);
}

