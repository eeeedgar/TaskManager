package com.company;

public class Task {
    private int id;
    private String objective;
    private boolean status;
    public Task (int id, String text) {
        this.id = id;
        this.objective = text;
    }
    public int getId () {
        return id;
    }
    public String getObjective () {
        return objective;
    }
    public boolean getStatus () {
        return status;
    }
    public void setId (int id) {
        this.id = id;
    }
    public void setObjective (String objective) {
        this.objective = objective;
    }
    public void setStatus (boolean status) {
        this.status = status;
    }
    public void complete () {
        status = true;
    }
}

