package com.company;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException
    {
        char c;
        String input_line = "";
        String first_cmd_word;
        String second_cmd_word;
        int tasks_number = 0;
        ArrayList<Task> tasks = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            input_line = br.readLine();
            first_cmd_word = "";
            second_cmd_word = "";
            String deleted_task_name;
            int id_to_delete = 0;
            for (int i = 0;first_cmd_word.length() < input_line.length() && input_line.charAt(i) != (' ');i++)
                first_cmd_word += input_line.charAt(i);
            //System.out.println(first_cmd_word.length());
            for (int i = first_cmd_word.length()+1;i < input_line.length() ;i++)
                second_cmd_word += input_line.charAt(i);
            switch (first_cmd_word) {
                case ("add"):
                    //System.out.println(second_cmd_word);
                    tasks_number++;
                    tasks.add(new Task(tasks_number, second_cmd_word));
                    System.out.println("Task " + tasks.get(tasks_number-1).name+ " added succesfully");
                    break;
                case ("all"):
                    //System.out.println("okay");
                    if (tasks.size()>0)
                    {
                        for (int i = 0; i < tasks.size(); i++)
                            System.out.println(tasks.get(i).id + " " + tasks.get(i).name + " " + tasks.get(i).status);
                    }
                    else
                    {
                        System.out.println("No tasks");
                    }
                    break;
                case ("delete"):
                    id_to_delete = Integer.parseInt(second_cmd_word);
                    if (id_to_delete < tasks_number + 1 && id_to_delete > 0)
                    {
                        ///System.out.println(tasks_number);
                        //System.out.println(id_to_delete);
                        //System.out.println(id_to_delete);
                        deleted_task_name = tasks.get(id_to_delete - 1).name;
                        tasks.remove(id_to_delete - 1);
                        tasks_number--;
                        for (int i = id_to_delete - 1; i < tasks_number; i++)
                            tasks.get(i).id--;
                        System.out.println("Task " + deleted_task_name + " deleted succesfully");
                    }
                    else
                    {
                        System.out.println("No such task");
                    }
                        break;
                case ("help"):
                    System.out.println("'add task-info'");
                    System.out.println("'all'");
                    System.out.println("'delete id' - id must be int right now (will be fixed soon)");
                    System.out.println("'save file-name.txt' - soon");
                    System.out.println("'load file-name.txt' - soon");
                    System.out.println("'complete id' - soon");
                    System.out.println("'completed' - soon");
                    break;
                case ("end"):
                    break;
                default:
                    System.out.println("Wrong command. Print 'help' to see available commands.");
                    break;
            }
        }   while (!input_line.equals("end"));
        //System.out.println(br);
        //System.out.println(input_line);
        //System.out.println(input_line.length());
        System.out.println("See you next time!");
    }
}