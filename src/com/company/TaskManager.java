package com.company;

import java.util.ArrayList;

public class TaskManager {
    private int currentTaskNumber = 0;
    private int uniqueTaskNumber = 0;
    private ArrayList<Task> taskList = new ArrayList<Task>();
    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
        currentTaskNumber = taskList.size();
    }
    public int getCurrentTaskNumber() {
        return currentTaskNumber;
    }
    public int getUniqueTaskNumber() {
        return uniqueTaskNumber;
    }
    public void setUniqueTaskNumber(int uniqueTaskNumber) {
        this.uniqueTaskNumber = uniqueTaskNumber;
    }
    public void addTask(Task task) {
        try {
            taskList.add(task);
            currentTaskNumber++;
            uniqueTaskNumber++;
            System.out.println("task is added successfully");
        } catch (Exception exc) {
            System.out.println("error-1");
        }

    }
    public void getAllTasks() {
        try {
            for (int i = 0; i < currentTaskNumber; i++) {
                Task task = taskList.get(i);
                System.out.println(task.getId() + " " + task.getObjective() + " " + task.getStatus());
            }
        } catch (Exception exc) {
            System.out.println("error");
        }
    }
    public void getCompletedTasks() {
        try {
            for (int i = 0; i < currentTaskNumber; i++) {
                Task task = taskList.get(i);
                if (task.getStatus()) {
                    System.out.println(task.getId() + " " + task.getObjective());
                }
            }
        } catch (Exception exc) {
            System.out.println("error");
        }
    }
    public void deleteTask(String idString) {
        try {
            int i=0;
            int id = Integer.parseInt(idString);
            while (i < currentTaskNumber && taskList.get(i).getId() != id) {
                i++;
            }
            taskList.remove(i);
            currentTaskNumber--;
            System.out.println("task was deleted successfully");
        } catch (Exception exc) {
            System.out.println("illegal id");
        }
    }
    public void sortTasks() {
        int i = 0;
        int checkNumber = currentTaskNumber;
        try {
            while (i < checkNumber) {
                Task task = taskList.get(i);
                if (task.getStatus()) {
                    for (int j=i; j<currentTaskNumber-1; j++) {
                        taskList.set(j, taskList.get(j+1));
                    }
                    taskList.set(currentTaskNumber-1, task);
                    checkNumber--;
                }
                else {
                    i++;
                }
            }
        } catch (Exception exc) {
            System.out.println("error");
        }

    }
    public void completeTask(int id) {
        try {
            taskList.get(id).complete();
            System.out.println("task was completed");
        } catch (Exception exc) {
            System.out.println("error");
        }

    }
    public Task getTask(int number) {
        Task task = taskList.get(number);
        return task;
    }
}
