package com.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Coll2 {
    private List<User> userList;
    private Set<User> userSet;
    private Map<String, User> userMap;
    private Map<String, List<User>> mapList;

    @Override
    public String toString() {
        return "Coll2{" +
                "userList=" + userList +
                ", userSet=" + userSet +
                ", userMap=" + userMap +
                ", mapList=" + mapList +
                '}';
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Map<String, List<User>> getMapList() {
        return mapList;
    }

    public void setMapList(Map<String, List<User>> mapList) {
        this.mapList = mapList;
    }
}
