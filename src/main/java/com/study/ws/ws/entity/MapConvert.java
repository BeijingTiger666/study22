package com.study.ws.ws.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="map")
@XmlSeeAlso({Teacher.class,StudentVO.class})
public class MapConvert {
    public static class Entry<Object> {
        private String key;
        private Object value;
        public Entry() {
            super();
        }
        public Entry(String key, Object value) {
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
    private List<Entry> entries2 = new ArrayList<>();   // @XmlTransient

    public List<Entry> getEntries() {
        return entries2;
    }
    public void setEntries(List<Entry> entries) {
        this.entries2 = entries;
    }
}
