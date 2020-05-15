package com.Alex.iostreams;

import java.io.*;

/**
 * Объект FileWriter записывает данные в файл. При вводе/выводе практически всегда применяется буферизация
 * (попробуйте прочитать файл без нее, и вы увидите, что скорость чтения уменьшится в несколько раз),
 * поэтому мы присоединяем надстройку BufferedWriter.
 * После этого подключается PrintWriter, чтобы выполнять форматированный вывод. Файл данных, созданный
 * такой конфигурацией ввода/вывода, можно прочитать как обычный текстовый файл.
 *
 * Когда данные входного потока исчерпываются, метод readLine() возвращает null.
 * Для потока out явно вызывается метод close(); если не вызвать его для всех выходных файловых потоков,
 * в буферах могут остаться данные, и файл получится неполным.
 */
public class BasicFileOutput {
    static String file = "..\\JavaLearning\\src\\com\\Alex\\iostreams\\BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        ReadTextFromFile.read("..\\JavaLearning\\src\\com\\Alex\\iostreams\\BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;

        while((s = in.readLine()) != null )
            out.println(lineCount++ + ": " + s);
        out.close();
        // Вывод содержимого файла
        System.out.println(ReadTextFromFile.read(file));
    }
}
