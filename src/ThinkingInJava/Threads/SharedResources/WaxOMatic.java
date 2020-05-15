package ThinkingInJava.Threads.SharedResources;

/* Рассмотрим простой пример. В программе WaxOMatic.java задействованы два процесса: один наносит восковую пасту
на автомашину (Саr), а другой полирует ее. Задача полировки не может приступить к работе до того,
как задача нанесения пасты завершит свою операцию, а задача нанесения пасты должна ждать завершения полировки,
чтобы наложить следующий слой пасты. Оба класса, WaxOn и WaxOff, используют объект Саr, который приостанавливает
и возобновляет задачи в ожидании изменения условия:
 */

import java.util.concurrent.*;

class Car {
    private boolean waxOn = false;
    public synchronized void waxed() {
        waxOn = true; // Готово к обработке
        notifyAll();
    }
    public synchronized void buffed() {
        waxOn = false; // Готово к нанесению очередного слоя
        notifyAll();
    }
    public synchronized void waitForWaxing() throws InterruptedException {
        while(waxOn == false)
            wait();
    }
    public synchronized void waitForBuffing() throws InterruptedException {
        while(waxOn == true)
            wait();
    }
}

class WaxOn implements Runnable {
    private Car car;
    public WaxOn(Car c) { car = c; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.println("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch(InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}

class WaxOff implements Runnable {
    private Car car;
    public WaxOff(Car c) { car = c; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch(InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5); // Небольшая задержка...
        exec.shutdownNow(); // Прерывание всех задач
    }
}