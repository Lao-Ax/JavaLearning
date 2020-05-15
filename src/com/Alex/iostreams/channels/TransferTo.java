package com.Alex.iostreams.channels;

// Использование метода transferToO для соединения каналов
// {Параметры TransferTo java TransferTo txt}
import java.nio.channels.*;
import java.io.*;

/**
 * Лучший способ для копирования файлов.
 * Специальные методы, transferTo() и transferFrom(), позволяют напрямую присоединить один канал к другому:
 */
public class TransferTo {
    public static void main(String[] args) throws Exception {
        if(args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }

        FileChannel
                in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();

        in.transferTo(0, in.size(), out);
        // Or: out.transferFrom(in, 0, in.size());
    }
}
