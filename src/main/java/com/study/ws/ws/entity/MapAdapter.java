package com.study.ws.ws.entity;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.Map;

public class MapAdapter extends XmlAdapter<MapConvert, Map<String, Object>> {

    @Override
    public Map<String, Object> unmarshal(MapConvert v) throws Exception {
        Map<String, Object> resMap = new HashMap<>();
        for (MapConvert.Entry entry : v.getEntries()) {
            resMap.put(entry.getKey(), entry.getValue());
        }
        return resMap;
    }
    @Override
    public MapConvert marshal(Map<String, Object> v) throws Exception {
        MapConvert sf = new MapConvert();
        for (String key : v.keySet()) {
            sf.getEntries().add(new MapConvert.Entry(key, v.get(key)));
        }
        return sf;
    }
}