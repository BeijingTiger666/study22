package com.study.ws.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="map")
@XmlSeeAlso({Teacher.class,StudentVO.class})
public class MapConvert2 {
    public static class Entry2<Object> {
        private String key;
        private Object value;
        public Entry2() {
            super();
        }
        public Entry2(String key, Object value) {
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
        public Object getValue() {
            return value;
        }
        public void setValue(Object value) {
            this.value = value;
        }
    }
    private List<Entry2> entries2 = new ArrayList<>();   // @XmlTransient

    public List<Entry2> getEntries() {
        return entries2;
    }
    public void setEntries(List<Entry2> entries) {
        this.entries2 = entries;
    }
}
