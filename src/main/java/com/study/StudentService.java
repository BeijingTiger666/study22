package com.study;

import com.study.com.entity.MapAdapter;
import com.study.com.entity.StudentVO;
import com.study.com.entity.Teacher;
//import org.springframework.http.MediaType;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;
import java.util.Map;

@WebService
public interface StudentService{
    @WebMethod
    @GET
    @Path(value = "/students")
    @Produces(MediaType.APPLICATION_XML)
    @HeaderParam(value = MediaType.APPLICATION_XML)
    List<StudentVO> students();
    @WebMethod
    @GET
    @Path(value ="/studentxiaoming")
    @Produces(value = {MediaType.APPLICATION_XML})
//    @Consumes({"application/json","application/xml"})
    StudentVO studentxiaoming();
    @WebMethod
    @GET
    @Path(value ="/student/{sNo}")
    @Produces(value = MediaType.APPLICATION_XML)
    @Consumes({"application/json","application/xml"})
    StudentVO student(@PathParam("sNo") String sNo);
    @WebMethod
    @GET
    @Path(value ="/mapdemo")
    @Produces(value = MediaType.APPLICATION_XML)
    @XmlJavaTypeAdapter(MapAdapter.class)
    Map<String, Teacher> mapdemo();


}
