package com.Alex.iostreams.channels;

import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.*;


/**
 * Класс java.nio.CharBuffer содержит метод toString(), который возвращает строку из
 * символов, находящихся в данном буфере. Байтовый буфер ByteBuffer можно рассматривать
 * как символьный буфер CharBuffer, как это делается в методе asCharBuffer(). Но это не
 * работает.
 *
 * Поэтому можно сделать так: вызвать для буфера метод rewind(), чтобы вернуться к его началу.
 * Затем использовать кодировку по умолчанию в методе decode(). Данные буфера CharBuffer будут
 * правильно выведены на консоль.
 * Чтобы узнать кодировку по умолчанию вызовите метод System.getProperty("fiLe.encoding"),
 * который возвращает строку с названием кодировки.
 *
 * Передавая эту строку методу Charset.forName(), вы получите объект Charset,
 * с помощью которого и декодируете строку.
 */
public class BufferToText {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer()); // Doesn't work.

        // Decode using this system's default Charset:
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": " + Charset.forName(encoding).decode(buff));


        // Or, we could encode with something that will print:
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();

        // Now try reading again:
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

        // Use a CharBuffer to write through:
        fc = new FileOutputStream("data2.txt").getChannel();
        buff = ByteBuffer.allocate(24); // More than needed
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();

        // Read and display:
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
}
