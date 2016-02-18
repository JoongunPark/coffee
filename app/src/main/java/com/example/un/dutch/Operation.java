package com.example.un.dutch;

/**
 * Created by un on 16. 1. 27..
 */
public class Operation {
    private int maintain;
    private int interval;
    private int number;

    public Operation(int number, int maintain, int interval){
        this.number = number;
        this.maintain = maintain;
        this.interval = interval;
    }

    public int getNumber() {
        return this.number;
    }

    public int getMaintain() {
        return this.maintain;
    }

    public int getInterval() {
        return this.interval;
    }
}
