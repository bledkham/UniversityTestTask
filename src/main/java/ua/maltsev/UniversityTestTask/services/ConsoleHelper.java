package ua.maltsev.UniversityTestTask.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String s = null;
        try {
            s = bfr.readLine();
        } catch (IOException ignore) {
            System.out.println("Error! Please, try again!");
            return readString();
        }
        return s;
    }

    public static int readInt(){
        int a = 0;
        try {
            a = Integer.parseInt(readString());
        } catch (NumberFormatException ignore) {
            System.out.println("Error! Please, try again!");
            return readInt();
        }
        return a;
    }
}
