//package com.javacodegeeks.basics;

import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Console console = System.console();
        if(console != null) {
            Scanner sc = new Scanner(console.reader());
            System.out.println("Enter your name - ");
            String input = sc.nextLine();
            System.out.println("Hello "+input);
        }else {
            System.out.println("Console is null");
        }

    }

}
