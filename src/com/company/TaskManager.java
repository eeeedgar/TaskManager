package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class TaskManager {
    public ArrayList<Task> tasks = new ArrayList<>();
    public void AddTask(String task_name){
        tasks.add(new Task(tasks.size()+1, task_name, false));
    }
    public void DeleteTask(int task_number) {
        try {
            int i=0;
            while (tasks.get(i).id != task_number){
                i++;
            }
            tasks.remove(i);

        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("delete error");
        }catch (NumberFormatException exc){
            System.out.println("non int id");
        }
    }
    public void ShowTasks() throws IOException {
        for (int i=0;i<tasks.size();i++){
            System.out.println(tasks.get(i).id + " " + tasks.get(i).objective + " " + tasks.get(i).GetStatus());
        }
    }
    public void SortTasks() {
        try{
            int range = tasks.size();
            int i = 0;
            for (int count=0;count<range;count++){
                if (tasks.get(i).status) {
                    tasks.add(tasks.get(i));
                    tasks.remove(i);
                }
                else{
                    i++;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("sort error");
        }
    }
    public void GetCompletedTasks() throws IOException{
        for (int i=0;i<tasks.size();i++){
            if (tasks.get(i).status){
                System.out.println(tasks.get(i).id + " " + tasks.get(i).objective);
            }
        }
    }
}