package com.study.ws.test;

import com.study.ws.entity.Company;
import com.study.ws.entity.JavaEngineer;
import com.study.ws.entity.Movie;
import com.study.ws.entity.Student;
import com.study.ws.ws.entity.StudentVO;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.TemplateSpec;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.ExpressionContext;
import org.thymeleaf.templateresolver.DefaultTemplateResolver;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
/*
HashMap 是jdk1.2引进的,继承自AbstractMap类。但二者都实现了Map接口。

Hashtable继承自Dictionary类，Dictionary类是一个已经被废弃的类（见其源码中的注释）。父类都被废弃，自然而然也没人用它的子类Hashtable了。

HashTable键值都不能为null

Hashtable 没用遵循驼峰命名法

Hashtable线程安全, 想线程安全的化可以使用ConcurrentHashMap

TreeSet默认自然顺序的有序集合
非线程安全

TreeSet是SortedSet接口的唯一实现类，TreeSet可以确保集合元素处于排序状态。TreeSet支持两种排序方式，自然排序 和定制排序，其中自然排序为默认的排序方式。向TreeSet中加入的应该是同一个类的对象。LinkedHashSet可保证遍历顺序与插入顺序一样

TreeMap
1.无序，不允许重复（无序指元素顺序与添加顺序不一致）
2.TreeMap集合默认会对键进行排序，所以键必须实现自然排序和定制排序中的一种
3..底层使用的数据结构是二叉树
 */
public class NoSpringTest {
    public static void main(String[] args) throws ClassNotFoundException {
        final Class<?> aClass = Class.forName("com.study.ws.ws.entity.StudentVO");

        final Field[] fields = aClass.getFields();
        for (final Field field : fields) {
            final String name = field.getName();
            System.out.println(name);
        }
//        try {
////            throw new NullPointerException("哈哈");
//            final File file = new File("k");
//            final FileReader fileReader = new FileReader(file);
//        }catch (NullPointerException | FileNotFoundException e){
//
//        }
    }
    @Test
    public void sdfs2333d2af22() throws IOException, ClassNotFoundException {
        ObjectOutputStream oos=new ObjectOutputStream( new FileOutputStream("d://as.txt"));//输出流(处理流)
        oos.writeObject(new Student("娃娃","sss",22));//对象输出到输出流中
        oos.flush();
        oos.close();
        final ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("d://as.txt"));
        final Object o = inputStream.readObject();
        inputStream.close();
        System.out.println(o instanceof Student);
        Student s = (Student) o;
        System.out.println(s);
    }
    @Test
    public void sdfs2d2af22() throws IOException {
        String[] array = new String[]{"123","456"};
        final List<String> strings = Arrays.asList(array);

        final Properties p = new Properties();
        p.setProperty("a","222222");
        p.setProperty("b","嗡嗡嗡");
        p.setProperty("c","水水水水水水");
        final FileWriter fw = new FileWriter("d://sss.txt");
        p.store(fw,";;;");
        fw.close();
    }
    @Test
    public void sdfs2daf22() throws IOException {
        final TreeSet set1 = new TreeSet();
        set1.add("1");
        set1.add(1);
        set1.add(new Date());
        System.out.println(set1);
        final Object o = new Object();

//        final Properties p = new Properties();
//        p.load(new FileReader("d://22.txt"));
//        System.out.println(p);
//        final Set<Object> set = p.keySet();
//        for (final Object o : set) {
//            final Object o1 = p.get(o);
//            System.out.println(o+"--"+o1);
//        }
    }
    @Test
    public void sdfs2daf2()  {
        final Properties p = new Properties();
        p.setProperty("a","222222");
        p.setProperty("b","222222");
        p.setProperty("c","222222");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("d://a.txt","utf-8");
            p.list(pw);
        }catch (Exception e){

        }finally{
            pw.close();
        }

    }
    @Test
    public void sdfs2daf() {
        final TreeSet treeSet = new TreeSet();
        treeSet.add(new JavaEngineer(1,"的不"));
        treeSet.add(new JavaEngineer(1,"擦"));
        treeSet.add(new JavaEngineer(1,"啊"));
        treeSet.add(new JavaEngineer(1,"的从"));
        treeSet.add(new JavaEngineer(1,"的"));
        treeSet.add(new JavaEngineer(1,"的啊"));
        treeSet.add(new JavaEngineer(1,"不"));
        System.out.println(treeSet);

    }
    @Test
    public void sdfsdaf(){
        final Hashtable hashtable = new Hashtable();
//        hashtable.put("", null );
        final TreeSet treeSet = new TreeSet();
        TreeMap<Company, String> map=new TreeMap<>();
        map.put(new Company(1001, "百度", 2000, "李彦宏", "全球最大的中文搜索引擎、致力于让网民更便捷地获取信息，找到所求"),
                "有钱的公司，任性！！");
        map.put(new Company(1001, "腾讯", 10000, "马化腾", "深圳市腾讯计算机系统有限公司成立于1998年11月，由马化腾、张志东、许晨晔、陈一丹、曾李青五位创始人共同创立"),
                "有钱的公司，任性！！");
        map.put(new Company(1001, "小米", 5000, "雷军", "小米公司成立于2010年4月，是一家专注于智能产品自主研发的移动互联网公司"),
                "有钱的公司，任性！！");
        map.put(new Company(1001, "c", 10000, "马化腾", "深圳市腾讯计算机系统有限公司成立于1998年11月，由马化腾、张志东、许晨晔、陈一丹、曾李青五位创始人共同创立"),
                "有钱的公司，任性！！");
        map.put(new Company(1001, "饿了么", 10000, "马化腾", "深圳市腾讯计算机系统有限公司成立于1998年11月，由马化腾、张志东、许晨晔、陈一丹、曾李青五位创始人共同创立"),
                "有钱的公司，任性！！");
        map.put(new Company(1001, "非", 10000, "马化腾", "深圳市腾讯计算机系统有限公司成立于1998年11月，由马化腾、张志东、许晨晔、陈一丹、曾李青五位创始人共同创立"),
                "有钱的公司，任性！！");
        map.put(new Company(1001, "京东", 8000, "刘强东", "京东（JD.com）是中国最大的自营式电商企业，2015年第一季度在中国自营式B2C电商市场的占有率为56.3%"),
                "有钱的公司，任性！！");
        map.put(new Company(1001, "德邦", 10000, "马化腾", "深圳市腾讯计算机系统有限公司成立于1998年11月，由马化腾、张志东、许晨晔、陈一丹、曾李青五位创始人共同创立"),
                "有钱的公司，任性！！");
        map.put(new Company(1001, "阿里巴巴", 20000, "马云", "阿里巴巴网络技术有限公司（简称：阿里巴巴集团）"),
                "有钱的公司，任性！！");

        Set<Company> set=map.keySet();
        for (Company company : set) {
            System.out.println(company+","+map.get(company));
        }
//        System.out.println(treeSet);
    }
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
        final String s = FileUtils.readFileToString(new File("D:\\AAwork\\ideaWorkSpace\\study22\\src\\main\\resources\\templates\\entityModel.text"));
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
