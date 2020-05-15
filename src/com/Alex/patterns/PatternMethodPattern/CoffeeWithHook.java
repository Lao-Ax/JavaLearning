package com.Alex.patterns.PatternMethodPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alex on 23.12.2015 023.
 */
public class CoffeeWithHook extends Coffee {
    @Override
    boolean customerWantsCondiments() {
        String answer = getUserInput();

        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    private String getUserInput(){
        String answer = null;

        System.out.println("Would you like milk and sugar with your coffee (y/n)? ");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            answer = reader.readLine();
        } catch (IOException e) {
            System.err.println("IO error trying to read your answer.");
        }

        if (answer == null) {
            return "no";
        }

        return answer;
    }
}
