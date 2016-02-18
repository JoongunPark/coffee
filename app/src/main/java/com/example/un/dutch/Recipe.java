package com.example.un.dutch;

import java.util.ArrayList;

/**
 * Created by un on 16. 1. 27..
 */
public class Recipe {
    private ArrayList<Operation> operations;
    private String name;

    public void Recipe(String name){
        this.name = name;
        operations = new ArrayList<Operation>();
    }

    public void add(Operation oper) {
        operations.add(oper);
    }

    public String getName(){
        return name;
    }


}
