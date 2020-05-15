package com.Alex.iostreams.channels;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

/**
 *  Для любого из рассмотренных выше классов потоков метод getChannel() выдает канал FileChannel.
 *  Канал довольно прост: ему передается байтовый буфер ByteBuffer для чтения и записи.
 *
 *  Для помещения байтов в буфер ByteBuffer используется один из нескольких методов для записи данных (put);
 *  данные записываются в виде одного или нескольких байтов или значений примитивов.
 *  Впрочем, как было показано в примере, можно «заворачивать» уже существующий байтовый массив
 *  в буфер ByteBuffer, используя метод wrap(). Когда вы так делаете, байтовый массив не копируется,
 *  а используется как хранилище для полученного буфера ByteBuffer. В таких случаях говорят,
 *  что буфер ByteBuffer создается на базе массива.
 *
 *  Чтобы доступ к файлу ограничивался только чтением, следует явно получить байтовый буфер ByteBuffer
 *  статическим методом allocate(). Предназначение nio — быстрое перемещение большого количества данных,
 *  поэтому размер буфера имеет значение: на самом деле установленный в примере размер в 1 килобайт меньше,
 *  чем обычно требуется (поэкспериментируйте с работающим приложением, чтобы найти оптимальное решение).
 *
 *  Можно получить еще большее быстродействие, используя вместо метода allocate() метод allocateDirect().
 *  Он производит буфер «прямого доступа», еще теснее привязанный к низкоуровневой работе операционной системы.
 *  Однако такой буфер требует больше ресурсов, а реализация его различается в различных операционных системах.
 *
 *  После вызова метода read() буфера FileChannel для сохранения байтов в буфере ByteBuffer также
 *  необходимо вызвать для буфера метод flip(), позволяющий впоследствии извлечь из буфера его данные
 *  (да, все это выглядит немного неудобно, но помните, что расчет делался на высокое быстродействие,
 *  поэтому все делается на низком уровне). И если затем нам снова понадобится буфер для чтения,
 *  придется вызывать перед каждым методом read() метод clear().
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        // Write a file:
        FileChannel fc = new FileOutputStream("Data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        // Add to the end of the file:
        fc = new RandomAccessFile("Data.txt", "rw").getChannel();
        fc.position(fc.size()); // Move to the end
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        // Read the file:
        fc = new FileInputStream("Data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while(buff.hasRemaining())
            System.out.print((char)buff.get());
    }
}
