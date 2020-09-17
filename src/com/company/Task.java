package com.company;

public class Task {
    int id;
    String objective;
    boolean status;
    Task(int id, String objective, boolean status){
        this.id = id;
        this.objective = objective;
        this.status = status;
    }
    public String GetStatus(){
        if (status) {
            return ("(completed)");
        }
        else {
            return("(uncompleted)");
        }
    }
    public void Complete(){
        status = true;
    }
}
