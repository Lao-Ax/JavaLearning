package interviews;

public class AutoBoxing {

    static void doSmt(int i) {
        System.out.println(i);
    }

    static void methodBoxVar(int in) {
        System.out.println("int");
    }
    static void methodBoxVar(Integer in) {
        System.out.println("Integer");
    }

    static void methodBoxVar(Integer... i) {
        System.out.println("Integers");
    }

    public static void main(String[] args) {
        Integer io = 201;
        if (io == 201) {
            System.out.println("201 is 201!");
        }
        doSmt(io);
        System.out.println(io.byteValue());

        // примеры ниже - проверка на ссылочную целостность
        // В первом случае фактически вызывается статичный метод java.lang.Integer.valueOf(int),
        // который кэширует значения от -128 до 127 (верхнюю границу можно изменять) и при
        // повторном использовании достает их из так называемого pool (набор инициализированных и
        // готовых к использованию объектов). Во втором происходит явное создание объектов,
        // следовательно они имеют разные ссылки.
        Integer iOb1 = 100;
        Integer iOb2 = 100;
        System.out.println("1 " + (iOb1 == iOb2)); // true

        Integer iOb3 = new Integer(120);
        Integer iOb4 = new Integer(120);
        System.out.println("2 " + (iOb3 == iOb4)); // false

        Integer iOb5 = 200;
        Integer iOb6 = 200;
        System.out.println("3 " + (iOb5 == iOb6)); // false

        methodBoxVar(25);
        methodBoxVar(25, 25);
        methodBoxVar(new Integer(25));
    }

}
