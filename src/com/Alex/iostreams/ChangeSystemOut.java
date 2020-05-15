package com.Alex.iostreams;

import java.io.PrintWriter;

/**
 * Стандартный вывод System.out является объектом PrintStream, который, в свою очередь,
 * наследует от базового класса OutputStream. В классе PrintWriter имеется конструктор,
 * который принимает в качестве аргумента выходной поток OutputStream.
 * Таким образом, вы можете преобразовать поток стандартного вывода System.out в
 * символьно-ориентированный поток PrintWriter:
 */
public class ChangeSystemOut {

    public static void main(String[] args) {
        /* Важно использовать конструктор класса PrintWriter с двумя аргументами,
         * и передать во втором аргументе true, чтобы обеспечить автоматический сброс
         * буфера на печать, иначе можно вовсе не увидеть никакого вывода.
         */
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, world");
    }
}
