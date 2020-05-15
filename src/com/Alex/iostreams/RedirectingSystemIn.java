package com.Alex.iostreams;

import java.io.*;

/**
 * Программа присоединяет стандартный ввод к файлу и перенаправляет
 * стандартный вывод и поток для ошибок в другие файлы.
 * Обратите внимание на сохранение ссылки на исходный объект System.out
 * в начале программы и его восстановление в конце.
 *
 * Перенаправление основано на байтовом, а не на символьном вводе/выводе,
 * поэтому в примере используются InputStream и OutputStream,
 * а не их символьно-ориентированные эквиваленты Reader и Writer.
 */
public class RedirectingSystemIn {

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("..\\JavaLearning\\src\\com\\Alex\\iostreams\\RedirectingSystemIn.java"));

        PrintStream out = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("test.out")));

        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String s;
        while((s = br.readLine()) != null)
            System.out.println(s);
        out.close(); // Remember this!
        System.setOut(console);
    }
}
