package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Director {
    TaskManager taskManager = new TaskManager();
    CommandHandler commandHandler = new CommandHandler();
    FileHandler fileHandler = new FileHandler();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public void work() throws IOException {
        boolean flag = true;
        while (flag) {
            String request = new String();
            try {
                request = bufferedReader.readLine();
            } catch (IOException exc) {
                System.out.println("error-buffReader");
            }
            String action = commandHandler.getAction(request);
            String object = commandHandler.getObject(request);
            switch (action) {
                case ("help"):
                    System.out.println(" - add task-name\n - all\n - delete task-id\n - complete\n - task id\n - completed\n - end");
                    break;
                case ("add"):
                    if (object.length() > 0) {
                        taskManager.addTask(new Task(taskManager.getUniqueTaskNumber()+1, object));
                        taskManager.sortTasks();
                    }
                    break;
                case ("all"):
                    taskManager.getAllTasks();
                    break;
                case ("delete"):
                    taskManager.deleteTask(object);
                    break;
                case ("complete"):
                    int idComplete = Integer.parseInt(object);
                    taskManager.completeTask(idComplete);
                    taskManager.sortTasks();
                    break;
                case ("completed"):
                    taskManager.getCompletedTasks();
                    break;
                case ("load"):
                    fileHandler.scanFile(taskManager, object);
                    break;
                case ("save"):
                    fileHandler.recordFile(taskManager, object);
                    break;
                case ("end"):
                    System.out.println("see you next time!");
                    flag = false;
                    bufferedReader.close();
                    break;
                default:
                    System.out.println("error");
                    System.out.println("'" + action + "'");
                    System.out.println("print 'help' to see available commands");
                    break;
            }
        }
    }
}