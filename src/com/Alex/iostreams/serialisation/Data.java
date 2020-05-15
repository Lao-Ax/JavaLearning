package com.Alex.iostreams.serialisation;
import java.io.*;

/**
 * Пример проверяет механизм сериализации: мы создаем цепочку связанных объектов,
 * каждый из которых связан со следующим сегментом цепочки, а также имеет массив
 * ссылок на объекты другого класса с именем Data:
 */

class Data implements Serializable {
    private int n;

    public Data(int n) { this.n = n; }

    public String toString() { return Integer.toString(n); }
}