package com.company.CHALOGHARE;

public class TrainClasses {

    String name,atime,dtime;
    long number;

    public TrainClasses(String name, long number, String atime, String dtime) {
        this.name = name;
        this.number = number;
        this.atime = atime;
        this.dtime = dtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }
}
