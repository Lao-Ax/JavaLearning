package com.Alex.iostreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * PrintWriter появился вспомогательный конструктор. Благодаря ему вам не придется вручную
 * выполнять всю работу каждый раз, когда вам потребуется создать текстовый файл и записать в него данные.
 * Буферизация по-прежнему обеспечена, но вам не приходится включать ее самостоятельно.
 */
public class FileOutputShortcut {
    static String file = "..\\JavaLearning\\src\\com\\Alex\\iostreams\\FileOutputShortcut.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        ReadTextFromFile.read("..\\JavaLearning\\src\\com\\Alex\\iostreams\\FileOutputShortcut.java")));
        PrintWriter out = new PrintWriter(file); // Сокращенная запись
        int lineCount = 1;
        String s;

        while((s = in.readLine()) != null )
            out.println(lineCount++ + ": " + s);
        out.close();
        // Вывод содержимого файла
        System.out.println(ReadTextFromFile.read(file));
    }
}
