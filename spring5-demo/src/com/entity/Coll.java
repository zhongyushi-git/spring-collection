package com.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Coll {
    private List<String> listStr;
    private Set<String> setStr;
    private Map<String, String> mapStr;
    private Map<String, List<String>> mapList;

    public List<String> getListStr() {
        return listStr;
    }

    public void setListStr(List<String> listStr) {
        this.listStr = listStr;
    }

    public Set<String> getSetStr() {
        return setStr;
    }

    public void setSetStr(Set<String> setStr) {
        this.setStr = setStr;
    }

    public Map<String, String> getMapStr() {
        return mapStr;
    }

    public void setMapStr(Map<String, String> mapStr) {
        this.mapStr = mapStr;
    }

    public Map<String, List<String>> getMapList() {
        return mapList;
    }

    public void setMapList(Map<String, List<String>> mapList) {
        this.mapList = mapList;
    }

    @Override
    public String toString() {
        return "Coll{" +
                "listStr=" + listStr +
                ", setStr=" + setStr +
                ", mapStr=" + mapStr +
                ", mapList=" + mapList +
                '}';
    }
}
