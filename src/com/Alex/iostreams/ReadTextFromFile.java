package com.Alex.iostreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Чтобы открыть файл для посимвольного чтения, используется класс FileInputReader;
 * имя файла задается в виде строки (String) или объекта File.
 * Ускорить процесс чтения помогает буферизация ввода, для этого полученная ссылка
 * передается в конструктор класса BufferedReader. Так как в интерфейсе класса
 * имеется метод readLine(), все необходимое для чтения имеется в вашем распоряжении.
 * При достижении конца файла метод readLine() возвращает ссылку null.
 */
public class ReadTextFromFile {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine()) != null)
            sb.append(s + "\n");
        in.close();
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        System.out.print(read("..\\JavaLearning\\src\\com\\Alex\\iostreams\\ReadTextFromFile.java"));
    }
}
