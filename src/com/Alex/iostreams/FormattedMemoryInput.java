package com.Alex.iostreams;

import java.io.*;

/**
 * Для преобразования строки в массив байтов, пригодный для помещения в поток ByteArrayInputStream,
 * в классе String предусмотрен метод getBytes(). Полученный ByteArrayInputStream представляет собой
 * поток InputStream, подходящий для передачи DataInputStream.
 *
 * При побайтовом чтении символов из форматированного потока DataInputStream методом readByte()
 * любое полученное значение будет считаться действительным, поэтому возвращаемое значение
 * неприменимо для идентификации конца потока.
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            ReadTextFromFile.read(
                                    "..\\JavaLearning\\src\\com\\Alex\\iostreams\\FormattedMemoryInput.java").getBytes()));
            while (true)
                System.out.print((char) in.readByte());
        } catch (EOFException e) {
            System.err.println("End of stream");
        }
    }

    /**Вместо этого можно использовать метод available(),
     * который сообщает, сколько еще осталось символов. В следующем примере показано, как читать файл побайтно.
     * Заметьте, что метод available() работает по-разному в зависимости от источника данных;
     * дословно его функция описывается следующим образом: «количество байтов, которые можно прочитать без блокировки».
     * При чтении из файла это означает весь файл, но для другого рода потоков это не обязательно верно,
     * поэтому используйте этот метод разумно.
     *
     * Определить конец входного потока можно и с помощью перехвата исключения.
     * Впрочем, применение исключений в таких целях считается злоупотреблением.
     */
    static public class TestEOF {
        public static void main(String[] args) throws IOException {
            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("..\\JavaLearning\\src\\com\\Alex\\iostreams\\FormattedMemoryInput.java")));
            while (in.available() != 0)
                System.out.print((char) in.readByte());
        }
    }
}