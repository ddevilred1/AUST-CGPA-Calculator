package com.example.asus.austcgpacalculator;

/**
 * Created by Asus on 2/9/2018.
 */

public class Result {
    String user, semester;
    double cg;

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public double getCg() {
        return cg;
    }

    public void setCg(double cg) {
        this.cg = cg;
    }

    public String getUser() {

        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Result(String user, String semester, double cg) {

        this.user = user;
        this.semester = semester;
        this.cg = cg;
    }
}
