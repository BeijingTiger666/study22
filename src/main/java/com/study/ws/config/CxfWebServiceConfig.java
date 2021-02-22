package com.study.ws.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * cxf配置类
 * @author oKong
 *
 */
@Configuration
public class CxfWebServiceConfig {

    @Autowired
    private Bus bus;


    @Bean(name = "cxfServletRegistration")
    public ServletRegistrationBean dispatcherServlet() {
        //注册servlet 拦截/ws 开头的请求 不设置 默认为：/services/*
        return new ServletRegistrationBean(new CXFServlet(), "/ws/*");
    }

    /*
     * 发布endpoint
     */
//    @Bean
//    public Endpoint endpoint_SBSDMSDMImportItemInfoSrv() {
//        EndpointImpl endpoint = new EndpointImpl(bus, sBSDMSDMImportItemInfoSrv);
//        endpoint.publish("/SB_SDM_SDM_ImportItemInfoSrv");//发布地址
//        return endpoint;
//    }

}
