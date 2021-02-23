package com.company;

public class CommandHandler {
    public String getAction(String request) {
        String action = new String();
        if (request.contains(" ")){
            int i = 0;
            while (!(String.valueOf(request.charAt(i)).equals(" "))) {
                action += request.charAt(i);
                i++;
            }
        }
        else {
            action = request;
        }

        return action;
    }
    public String getObject(String request) {
        String object = new String();
        if (request.equals(getAction(request))) {
        }
        else {
            for (int i = getAction(request).length()+1; i < request.length(); i++) {
                object += request.charAt(i);
            }
        }
        return object;
    }
}
