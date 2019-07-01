package com.yoke.backend.Entity;

public class ClassSegment {
    private String classroom;
    private int begin_sec;
    private int end_sec;
    private int week;

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getBegin_sec() {
        return begin_sec;
    }

    public void setBegin_sec(int begin_sec) {
        this.begin_sec = begin_sec;
    }

    public int getEnd_sec() {
        return end_sec;
    }

    public void setEnd_sec(int end_sec) {
        this.end_sec = end_sec;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}
