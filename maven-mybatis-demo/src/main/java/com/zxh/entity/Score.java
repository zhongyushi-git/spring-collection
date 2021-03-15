package com.zxh.entity;

public class Score {

    private int id;
    private double grade;
    private int u_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", grade=" + grade +
                ", u_id=" + u_id +
                '}';
    }
}
