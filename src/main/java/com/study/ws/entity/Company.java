package com.study.ws.entity;

import java.text.CollationKey;
import java.text.Collator;

/**
 * 创建公司Company类，拥有属性：no(公司编号)、
 * name(公司名称)、num(公司人数)、founder(创始人)、
 * info(公司简介)，要求属性进行封装即：属性私有并提供公有方法。
 * @author Administrator
 *
 */
public class Company implements Comparable<Company>{
    private int no;
    private String name;
    private int num;
    private String founder;
    private String info;
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getFounder() {
        return founder;
    }
    public void setFounder(String founder) {
        this.founder = founder;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    @Override
    public String toString() {
        return "Company [no=" + no + ", name=" + name + ", num=" + num + ", founder=" + founder + ", info=" + info
                + "]";
    }
    public Company(int no, String name, int num, String founder, String info) {
        super();
        this.no = no;
        this.name = name;
        this.num = num;
        this.founder = founder;
        this.info = info;
    }
    public Company() {
        super();
    }
    //要求按照以下规则依次排序：公司编号、公司名称、创始人、公司人数,按升序排列
    @Override
    public int compareTo(Company o) {
        //公司编号
        int a=this.no-o.no;
        if(a!=0){
            return a;
        }else{
            //公司名称
            CollationKey key=Collator.getInstance().getCollationKey(this.name);
            CollationKey key2=Collator.getInstance().getCollationKey(o.name);
            int b=key.compareTo(key2);
            if(b!=0){
                return b;
            }else{
                //创始人
                CollationKey key3=Collator.getInstance().getCollationKey(this.founder);
                CollationKey key4=Collator.getInstance().getCollationKey(o.founder);
                int c=key3.compareTo(key4);
                if(c!=0){
                    return c;
                }else {
                    //公司人数
                    return this.num-o.num;
                }
            }
        }
    }

}