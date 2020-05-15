package com.Alex.iostreams;

import java.io.IOException;
import java.io.StringReader;

/**
 * В этой секции результат String файла ReadTextFromFile.read() используется для создания StringReader.
 * Затем символы последовательно читаются методом read(), и каждый следующий символ посылается на консоль.
 * Обратите внимание: метод read() возвращает следующий символ в формате int, и для правильного вывода
 * его необходимо предварительно преобразовать в char.
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException, InterruptedException {
        StringReader in = new StringReader(ReadTextFromFile.read("..\\JavaLearning\\src\\com\\Alex\\iostreams\\MemoryInput.java"));
        int c;
        while((c = in.read()) != -1) {
            Thread.sleep(200);
            System.out.print((char) c);
        }
    }
}
