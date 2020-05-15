package com.Alex.iostreams.serialisation;

import java.io.*;
import java.util.Random;

/**
 * Created by Alex on 07.01.2017 007.
 */
public class Worm implements Serializable {
    private static Random rand = new Random(47);

    private Data[] d = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };

    private Worm next;
    private char c;

    // Value of i == number of segments
    public Worm(int i, char x) {
        System.out.println("Worm constructor: " + i);
        c = x;
        if(--i > 0)
            next = new Worm(i, (char)(x + 1));
    }

    public Worm() {
        System.out.println("Default constructor");
    }

    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data dat : d)
            result.append(dat);
        result.append(")");
        if (next != null)
            result.append(next);
        return result.toString();
    }

    /**
     * Чтобы пример был интереснее, массив объектов Data в классе Worm инициализируется случайными числами.
     * (Таким образом, нельзя заподозрить компилятор в том, что он использует дополнительную информацию
     * для хранения объектов.)
     * Каждый объект Worm помечается порядковым номером-символом (char), который автоматически генерируется
     * в процессе рекурсивного формирования связанной цепочки объектов Worm. При создании цепочки ее размер
     * указывается в конструкторе класса Worm. Для инициализации ссылки next рекурсивно вызывается
     * конструктор класса Worm, однако с каждым разом размер цепочки уменьшается на единицу.
     * В последнем сегменте цепочки ссылка next остается со значением null, что указывает на конец цепочки.
     *
     * После создания потока ObjectOutputStream (на основе другого выходного потока), метод writeObject()
     * записывает в него объект. Заметьте, что в поток также записывается строка (String). В этот же поток
     * можно поместить все примитивные типы, используя те же методы, что и в классе DataOutputStream (оба
     * потока реализуют одинаковый интерфейс).
     *
     * В программе есть два похожих фрагмента кода. В первом запись и чтение производится в файл, а во
     * втором для разнообразия хранилищем служит массив байтов ByteArray. Чтение и запись объектов
     * посредством сериализации возможна в любые потоки, в том числе и в сетевые соединения.
     * Из выходных данных видно, что восстановленный объект в самом деле содержит все ссылки, которые
     * были в исходном объекте.
     *
     * Заметьте, что в процессе восстановления объекта, реализующего интерфейс Serializable, никакие
     * конструкторы (даже конструктор по умолчанию) не вызываются. Объект восстанавливается целиком и
     * полностью из данных, считанных из входного потока InputStream.
     */

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Worm w = new Worm(6, 'a');
        System.out.println("w = " + w);

        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("worm.out"));

        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close(); // Also flushes output

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("worm.out"));
        String s = (String)in.readObject();
        Worm w2 = (Worm)in.readObject();

        System.out.println(s + "w2 = " + w2);

        ByteArrayOutputStream bout =
                new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.flush();

        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(bout.toByteArray()));
        s = (String)in2.readObject();
        Worm w3 = (Worm)in2.readObject();

        System.out.println(s + "w3 = " + w3);
    }
}
