package com.company;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public void FileWriter(ArrayList<Task> tasks, String filename) {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try (FileWriter fileWriter = new FileWriter(filename)){
            for (int i=0;i< tasks.size();i++){
                fileWriter.write(tasks.get(i).id +" " +tasks.get(i).objective + " " + tasks.get(i).GetStatus()+"\n");
            }
        System.out.println("file saved successfully");
        } catch (IOException exc) {
            System.out.println("write file error");
        }

    }
    public void FileLoader(ArrayList<Task> tasks, String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))){
            String input_file_line = "";
            String input_file_line_formatted[];
            int id;
            String string_status;

            while ((input_file_line = bufferedReader.readLine())!=null) {
                String objective = "";
                try {
                    boolean status = false;
                    input_file_line_formatted = input_file_line.split(" ");
                    id = Integer.parseInt(input_file_line_formatted[0]);
                    string_status = input_file_line_formatted[input_file_line_formatted.length-1];
                    //System.out.println(string_status);
                    if (string_status.contains("(completed)")){
                        status = true;
                        //System.out.println("true");
                    }
                    for (int i=1;i<input_file_line_formatted.length-2;i++){
                        objective += input_file_line_formatted[i] + " ";
                    }
                    objective += input_file_line_formatted[input_file_line_formatted.length-2];
                    tasks.add(new Task(id, objective, status));
                } catch (NullPointerException exc) {
                    System.out.println(" error");
                } catch (StringIndexOutOfBoundsException exc) {
                    System.out.println("error");
                }
            }
        System.out.println("file loaded successfully");
        }
        catch (IOException exc) {
            System.out.println("load file error");
        }
    }
}
