package com.company;

import java.io.*;
import java.util.*;

public class FileHandler {
    public void scanFile(TaskManager taskManager, String fileName) {
        ArrayList<String> fileLines = new ArrayList<>();
        ArrayList<Task> taskList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                fileLines.add(scanner.nextLine());
            }
            fileReader.close();

            int[] idList = new int[fileLines.size()];
            for (int i = 0; i < fileLines.size(); i++) {
                Task task = analyseLine(fileLines.get(i));
                idList[i] = task.getId();
                taskList.add(task);
            }
            int maxId = idList[0];
            for (int i = 1; i < idList.length; i++) {
                if (idList[i] > maxId)
                    maxId = idList[i];
            }
            taskManager.setUniqueTaskNumber(maxId);
            taskManager.setTaskList(taskList);
            System.out.println("file loaded successfully" + " " + maxId);
        } catch (Exception exc) {
            System.out.println("file scan error");
        }
    }
    public Task analyseLine (String line) {
        Task task = new Task(-1, "default-task");

        String[] wordList = line.split(" ");

        int id = Integer.parseInt(wordList[0]);

        String text = new String();
        for (int i=1; i < wordList.length-2; i++) {
            text += wordList[i] + " ";
        }
        text += wordList[wordList.length-2];

        boolean status = false;
        if (wordList[wordList.length-1].equals("true")) {
            status = true;
        } else {
            status = false;
        }
        //boolean status = Boolean.getBoolean(wordList[wordList.length-1]);

        task.setId(id);
        task.setObjective(text);
        task.setStatus(status);
        return task;
    }
    public void recordFile(TaskManager taskManager, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for(int i = 0; i < taskManager.getCurrentTaskNumber(); i++) {
                Task task = taskManager.getTask(i);
                fileWriter.write(task.getId() + " " + task.getObjective() + " " + task.getStatus() + "\n");
            }
            fileWriter.close();
            System.out.println("file saved successfully");
        } catch (Exception exc) {
            System.out.println("file record error");
        }
    }
}
