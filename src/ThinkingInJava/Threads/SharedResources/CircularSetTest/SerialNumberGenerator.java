package ThinkingInJava.Threads.SharedResources.CircularSetTest;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber() {
        return serialNumber++; // Операция не является потоково-безопасной
    }
}