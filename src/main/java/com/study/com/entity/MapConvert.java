package com.study.com.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="teachers")
public class MapConvert {
    public static class Entry{
        private String key;
        private Teacher value;
        public Entry() {
            super();
        }
        public Entry(String key, Teacher value) {
            super();
            this.key = key;
            this.value = value;
        }
        public String getKey() {
            return key;
        }
        public void setKey(String key) {
            this.key = key;
        }
        public Teacher getValue() {
            return value;
        }
        public void setValue(Teacher value) {
            this.value = value;
        }
    }
    private List<Entry> entries = new ArrayList<>();
    public List<Entry> getEntries() {
        return entries;
    }
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
