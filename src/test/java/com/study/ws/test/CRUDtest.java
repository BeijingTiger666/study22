package com.study.ws.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.study.ws.mapper.MovieMapper;
import org.apache.catalina.core.ApplicationContext;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.web.SpringBootMockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.context.ApplicationContext;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.TemplateSpec;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.ExpressionContext;
import org.thymeleaf.context.WebExpressionContext;
import org.thymeleaf.spring5.context.webflux.SpringWebFluxExpressionContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.util.ContentTypeUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CRUDtest {
    @Autowired
    MovieMapper mapper;
    @Autowired
    org.springframework.context.ApplicationContext ac;
    @Test
    public void testMovie(){
//        final List<Movie> list = mapper.selectList(null);
//        final Movie movie = mapper.selectById(1);
//        final Movie movie = mapper.sss("1");
//        final Object druid = ac.getBean("cxfServletRegistration");
        final DruidDataSource druid = (DruidDataSource) ac.getBean("druidDataSource");
        System.out.println(druid.getInitialSize());
    }

    @Test
    public void codegen() throws IOException {
//        FileTemplateResolver resolver = new FileTemplateResolver();
//        final EngineConfiguration configuration = new EngineConfiguration();

        final String ownerTemplate = "";
        final String template = "";
        final Map<String, Object> templateResolutionAttributes = new HashMap();

        final TemplateEngine engine = new TemplateEngine();
        final SpringBootMockServletContext context1 = new SpringBootMockServletContext("demo.html");
        final ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(context1);
        final FileWriter writer = new FileWriter("d://demo.html");
//        new SpringWebFluxExpressionContext();
//        new WebExpressionContext();
        final Context context = new Context();
        context.setVariable("msg", "牛逼哈哈哈!!!");
//        new ExpressionContext();
        final String s = FileUtils.readFileToString(new File("E:\\AAAimportant\\idea2019workSpace\\study22\\src\\main\\resources\\templates\\demo.html"));
//        engine.process("<!DOCTYPE html><html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\"><head><meta charset=\"UTF-8\"></head><body><h1 th:text=\"${msg}\">哈哈</h1><h1  >hehe</h1></body></html>", context, writer);
        final TemplateSpec spec = new TemplateSpec(s, "HTML");

        engine.process(spec , context, writer);
        System.out.println(spec.getTemplateResolutionAttributes());
//        new ExpressionContext();
//        engine.process("demo", context1, writer);
//        engine.setTemplateResolver(resolver);

//        engine.process();
//        resolver.resolveTemplate();
    }

}
