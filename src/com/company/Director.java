package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Director {
    TaskManager taskManager = new TaskManager();
    CommandAnalyzer commandAnalyzer = new CommandAnalyzer();
    FileManager fileManager = new FileManager();
    public boolean flag = true;
    String commands[] = new String[2];
    String action = "";
    String object = "";
    public void Work() throws IOException {
        while (flag){
            try {
                commands = commandAnalyzer.GetCommand().split("%%");
                action = commands[0];
                object = commands[1];

            }
            catch (ArrayIndexOutOfBoundsException exc) {
                try{
                    action = commands[0];
                }
                catch (ArrayIndexOutOfBoundsException exc1){
                    action = "";
                    System.out.println("incorrect input");
                }


            }
            finally {
                switch (action){
                    case("all"):
                        taskManager.ShowTasks();
                        break;
                    case("add"):
                        try{
                            taskManager.AddTask(object);
                            System.out.println("task added successfully");
                        }
                        catch (NullPointerException e){
                            System.out.println("incorrect");
                        }
                        break;
                    case("delete"):
                        try {
                            taskManager.DeleteTask(Integer.parseInt(object));
                            System.out.println("task was deleted successfully");
                        }
                        catch(NullPointerException exc){
                            System.out.println("make a correct request-1");
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("make a correct request-2");
                        }
                        catch (NumberFormatException exc){
                            System.out.println("non a number id");
                        }
                        break;
                    case("save"):
                        fileManager.FileWriter(taskManager.tasks, object);
                        break;
                    case("load"):
                        taskManager.tasks.clear();
                        fileManager.FileLoader(taskManager.tasks, object);
                        taskManager.SortTasks();
                        break;
                    case("complete"):
                        try{
                            int id = Integer.parseInt(object);
                            int i = 0;
                            while (taskManager.tasks.get(i).id!=id){
                                i++;
                            }
                            taskManager.tasks.get(i).Complete();
                            taskManager.SortTasks();
                            System.out.println("task was completed successfully");
                        }
                        catch (NullPointerException exc) {
                            System.out.println("complete error");
                        }
                        catch (ArrayIndexOutOfBoundsException exc) {
                            System.out.println("no such task");
                        }
                        catch (IndexOutOfBoundsException exc) {
                            System.out.println("complete error 404");
                        }
                        catch (NumberFormatException exc) {
                            System.out.println("non int id");
                        }
                        break;
                    case ("completed"):
                        taskManager.GetCompletedTasks();
                        break;
                    case("end"):
                        System.out.println("see you later!");
                        flag = false;
                        break;
                    default:
                        System.out.println("make a correct request");
                        break;
                    }
            }
        }
    }
}