package com.study.ws.entity;

import java.text.CollationKey;
import java.text.Collator;

public class JavaEngineer implements Comparable<JavaEngineer>{
    private int jeid;
    private String jename;

    public JavaEngineer(int jeid, String jename) {
        this.jeid = jeid;
        this.jename = jename;
    }

    @Override
    public int compareTo(JavaEngineer o) {
        int a = this.jeid-o.getJeid();
        if(a!=0){
            return a;
        }else{
            final CollationKey collationKey = Collator.getInstance().getCollationKey(this.jename);
            final CollationKey collationKey1 = Collator.getInstance().getCollationKey(o.getJename());
            return collationKey.compareTo(collationKey1);
        }
    }
    public int getJeid() {
        return jeid;
    }

    public void setJeid(int jeid) {
        this.jeid = jeid;
    }

    public String getJename() {
        return jename;
    }

    public void setJename(String jename) {
        this.jename = jename;
    }

    @Override
    public String toString() {
        return "JavaEngineer{" +
                "jeid=" + jeid +
                ", jename='" + jename + '\'' +
                '}';
    }
}
