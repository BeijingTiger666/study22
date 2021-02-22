package com.study.ws.test;

import com.study.ws.entity.Movie;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.TemplateSpec;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.ExpressionContext;
import org.thymeleaf.templateresolver.DefaultTemplateResolver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoSpringTest {
    @Test
    public void codegen() throws IOException {
        final TemplateEngine engine = new TemplateEngine();
        final FileWriter writer = new FileWriter("d://haha.java");
        final Context context = new Context();
        context.setVariable("package", "com.study");
        context.setVariable("import", "org.apache.common.*");
        context.setVariable("className", "Controller");
        final ArrayList<String> list = new ArrayList();
        list.add("name");
        list.add("age");
        list.add("sex");
        context.setVariable("fields", list);
        final List<Movie> movies = new ArrayList();
        final Movie m = new Movie();
        m.setSname("妖猫传");
        final Movie m2 = new Movie();
        m2.setSname("琅琊榜");
        movies.add(m2);
        final ArrayList<String> items = new ArrayList();
        items.add("hahah");
        items.add("213123123");
        items.add("cccccc");
        context.setVariable("items", items);
        context.setVariable("movies", movies);
//        context.setVariable("item", items);
        final String s = FileUtils.readFileToString(new File("E:\\AAAimportant\\idea2019workSpace\\study22\\src\\main\\resources\\templates\\entityModel.text"));
        final TemplateSpec spec = new TemplateSpec(s, "TEXT");

        engine.process(spec, context, writer);
    }

    @Test
    public void demo() throws IOException {
        final TemplateEngine engine = new TemplateEngine();
        final FileWriter writer = new FileWriter("d://demo.html");
        final Context context = new Context();
        context.setVariable("msg", "牛逼哈哈哈!!!");
//        engine.process("<!DOCTYPE html><html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\"><head><meta charset=\"UTF-8\"></head><body><h1 th:text=\"${msg}\">哈哈</h1><h1  >hehe</h1></body></html>", context, writer);

        final String s = FileUtils.readFileToString(new File("E:\\AAAimportant\\...\\demo.html"));
        final TemplateSpec spec = new TemplateSpec(s, "HTML");
        engine.process(spec, context, writer);
    }

}
