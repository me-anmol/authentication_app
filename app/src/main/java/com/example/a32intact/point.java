package com.example.a32intact;

public class point {
    private  String date;
    private  String time;
    private  String problem;

    public point() {
    }

    public point(String date, String time, String problem) {
        this.date = date;
        this.time = time;
        this.problem = problem;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}
