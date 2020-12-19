package com.study;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

public class WStest {
    public static void main(String[] args) {
//        调用WebService
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(WeatherServer.class);
        factory.setAddress("http://localhost:8087/ws/getWeatherByProvince?wsdl");

//        WeatherServer service = (WeatherServer) factory.create();
        WeatherServer service = (WeatherServer) factory.create();
        System.out.println(service.getWeather());

        // 创建WebService客户端代理工厂
//        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//        // 判断是否抛出异常
////        factory.getOutInterceptors().add(new LoggingInInterceptor());
//        // 注册webservice接口
//        factory.setServiceClass(DeductionService.class);
//        // 配置webservice地址
//        factory.setAddress("http://localhost:7002/card/services/HelloWorld?wsdl");
//        // 获得接口对象
//        CxfService service = (CxfService) factory.create();
//        // 调用接口方法
//        String result = service.sayHello("aaaaaaaaaa");
//        System.out.println("调用结果:" + result);
        // 关闭接口连接

    }
    @Test
    public void sdfas(){
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(NewsServer.class);
        factory.setAddress("http://localhost:8080/ws/studentService/students?wsdl");
//        http://localhost:8080/ws/studentService/studentxiaoming
//        http://localhost:8080/ws/studentService/student
//        http://localhost:8080/ws/studentService/students
//        http://localhost:8080/ws/getNews
        NewsServer service = (NewsServer) factory.create();
        final String whan = service.getNews("beijing");
        System.out.println(whan);
    }

}
