package com.company;
import java.io.*;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException
    {
        char c;
        String input_line = "";
        String first_cmd_word;
        String second_cmd_word;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            input_line = br.readLine();
            first_cmd_word = "";
            second_cmd_word = "";
            for (int i = 0;first_cmd_word.length() < input_line.length() && input_line.charAt(i) != (' ');i++)
                first_cmd_word += input_line.charAt(i);
            //System.out.println(first_cmd_word.length());
            for (int i = first_cmd_word.length()+1;i < input_line.length() ;i++)
                second_cmd_word += input_line.charAt(i);
            switch (first_cmd_word) {
                case ("add"):
                    System.out.println(second_cmd_word);

                    break;
                case ("all"):
                    System.out.println("okay");
                    break;
                case ("help"):
                    System.out.println("'add task-info'");
                    System.out.println("'all'");
                    System.out.println("'delete id'");
                    System.out.println("'save file-name.txt'");
                    System.out.println("'load file-name.txt'");
                    System.out.println("'complete id'");
                    System.out.println("'completed'");
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

