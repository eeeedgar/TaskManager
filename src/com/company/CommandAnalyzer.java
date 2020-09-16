package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CommandAnalyzer {
    public String GetCommand() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        String action = "";
        String object = "";
        //ArrayList<String> commands = new ArrayList<>();
        String commands[];
        try{
            line = bufferedReader.readLine();
            commands = line.split(" ");

            action = commands[0];
            for (int i=1;i<commands.length-1;i++){
                object += commands[i] + " ";
            }
            object += commands[commands.length-1];
        }
        catch (ArrayIndexOutOfBoundsException exc){
            System.out.println("incorrect input");
        }
        return (action + "%%" + object);
    }
}
