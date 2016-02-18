package com.example.un.dutch;


/**
 * Created by un on 16. 1. 27..
 */
public class Machine {
    private int id;
    private int status;
    private Recipe recipe;

    private final int IDLE = 1;
    private final int BREWING = 2;

    public Machine(int id){
        super();
        this.id = id;
        this.status = IDLE;
        recipe = new Recipe();
    }



    // getter, setter

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getStatus(){
        return this.status;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public Recipe getRecipe(){
        return recipe;
    }


}