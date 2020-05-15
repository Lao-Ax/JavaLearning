package com.Alex.iostreams.channels;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;


/**
 * В программе создаются два канала FileChannel: для чтения и для записи. Выделяется буфер ByteBuffer,
 * а когда метод FileChannel.read() возвращает -1, это значит, что мы достигли конца входных данных.
 * После каждого вызова метода read(), помещающего данные в буфер, метод flip() подготавливает буфер
 * так, чтобы информация из него могла быть извлечена методом write().
 * После вызова write() информация все еще хранится в буфере, поэтому метод clear() перемещает все его
 * внутренние указатели, чтобы буфер снова был способен принимать данные в методе read(). Впрочем,
 * рассмотренная программа не лучшим образом выполняет копирование файлов.
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }

        FileChannel
                in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);

        while(in.read(buffer) != -1) {
            buffer.flip(); // Prepare for writing
            out.write(buffer);
            buffer.clear();  // Prepare for reading
        }
    }
}
