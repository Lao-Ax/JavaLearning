package com.Alex.iostreams;

import java.io.*;

/**
 * для вывода информации, предназначенной для другого потока, следует использовать
 * классы DataOutputStream (для записи данных) и DataInputStream (для чтения данных).
 * Надстройки DataOutputStream и DataInputStream ориентированы на посылку байтов,
 * поэтому для них требуются потоки OutputStream и InputStream.
 */
public class StoringAndRecoveringData {

    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("Data.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();

        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("Data.txt")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF()); // Только readUTF() нормально читает строки в кодировке UTF для Java:
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }

    /**
     * Если данные записываются в выходной поток DataOutputStream, язык Java гарантирует,
     * что эти данные в точно таком же виде будут восстановлены входным потоком DataInputStream —
     * невзирая на платформу, на которой производится запись или чтение.
     * Единственным надежным способом записать в поток DataOutputStream строку (String) так,
     * чтобы ее можно было потом правильно считать потоком DataInputStream, является
     * кодирование UTF-8, реализуемое методами readUTF() и writeUTF().
     */
}
