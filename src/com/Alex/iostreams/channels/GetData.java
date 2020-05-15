package com.Alex.iostreams.channels;

import java.nio.*;

public class GetData {

    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);

        /* После выделения байтового буфера мы убеждаемся в том, что его содержимое
         * действительно заполнено нулями. Проверяются все 1024 значения, хранимые
         * в буфере (вплоть до последнего, индекс которого (размер буфера) возвращается
         * методом limit()), и все они оказываются нулями. */
        int i = 0;
        while(i++ < bb.limit())
            if(bb.get() != 0)
                System.out.print("nonzero");
        System.out.println("i = " + i);
        bb.rewind();


        /* Простейший способ вставить примитив в ByteBuffer основан на получении
         * подходящего «представления» этого буфера методами asCharBuffer(), asShortBuffer()
         * и т. п., и последующем занесении в это представление значения методом put().*/
        // Store and read a char array:
        bb.asCharBuffer().put("Howdy!");
        char c;
        while((c = bb.getChar()) != 0)
            System.out.print(c + " ");
        System.out.println();
        bb.rewind();

        // Store and read a short:
        bb.asShortBuffer().put((short)471142); // !!! need to be cast!
        System.out.println(bb.getShort());
        bb.rewind();

        // Store and read an int:
        bb.asIntBuffer().put(99471142);
        System.out.println(bb.getInt());
        bb.rewind();

        // Store and read a long:
        bb.asLongBuffer().put(99471142);
        System.out.println(bb.getLong());
        bb.rewind();

        // Store and read a float:
        bb.asFloatBuffer().put(99471142);
        System.out.println(bb.getFloat());
        bb.rewind();

        // Store and read a double:
        bb.asDoubleBuffer().put(99471142);
        System.out.println(bb.getDouble());
        bb.rewind();

        bufferViews();
    }

    /**
     * «Представления буферов» дают вам возможность взглянуть на соответствующий байтовый
     * буфер «через призму» некоторого примитивного типа. Байтовый буфер все так же хранит
     * действительные данные и одновременно поддерживает представление, поэтому все
     * изменения, которые вы сделаете в представлении, отразятся на содержимом байтового
     * буфера. Как было показано в предыдущем' примере, это удобно для вставки значений
     * примитивов в байтовый буфер. Представления также позволяют читать значения примитивов
     * из буфера, по одному (раз он «байтовый» буфер) или пакетами (в массивы).
     * Следующий пример манипулирует целыми числами (int) в буфере ByteBuffer с помощью
     * класса IntBuffer:
     */
    public static void bufferViews() {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer(); // представление

        // Store an array of int:
        ib.put(new int[]{ 11, 42, 47, 99, 143, 811, 1016 });

        // Absolute location read and write:
        System.out.println(ib.get(3));

        ib.put(3, 1811);

        // Setting a new limit before rewinding the buffer.
        ib.flip();
        while(ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }
    }
}
