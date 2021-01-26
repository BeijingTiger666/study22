package com.study.com.entity;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.Map;

public class MapAdapter2 extends XmlAdapter<MapConvert2, Map<String, Object>> {

    @Override
    public Map<String, Object> unmarshal(MapConvert2 v) throws Exception {
        Map<String, Object> resMap = new HashMap<>();
        for (MapConvert2.Entry2 entry : v.getEntries()) {
            resMap.put(entry.getKey(), entry.getValue());
        }
        return resMap;
    }
    @Override
    public MapConvert2 marshal(Map<String, Object> v) throws Exception {
        MapConvert2 sf = new MapConvert2();
        for (String key : v.keySet()) {
            sf.getEntries().add(new MapConvert2.Entry2(key, v.get(key)));
        }
        return sf;
    }
}