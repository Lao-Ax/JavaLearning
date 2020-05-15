package com.Alex.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Draft and experemental class.
 * The simple http server to manage xml feeds for testing purposes.
 * It's API must contain two methods: getFeed() and swap().
 */
public class Server {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final ServerSocket serverSocket;
    private boolean isReadyToClose;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    // Test method. TODO: Delete this.
    public static void main(String[] args) throws IOException {
        Server server = new Server(81);
        server.run();
    }

    /**
     * To start the server.
     *
     * @throws IOException
     */
    public void run() throws IOException {
        while (!isReadyToClose) {
            final Socket connection = serverSocket.accept();
            Runnable task = () -> this.handleRequest(connection);
            executor.execute(task);
        }
    }

    private void handleRequest(Socket s) {
        String request;

        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter out = new PrintWriter(s.getOutputStream(), true)
        ) {
            String webServerAddress = s.getInetAddress().toString();
            System.out.println("New Connection:" + webServerAddress);

            request = in.readLine().split(" ")[1];
            System.out.println("--- Client request: " + request);

            switch (request) {
                case "/getFeed": {
                    getFeed(s, out);
                    break;
                }
                case "/swap": {
                    swapXmls(s, out);
                    break;
                }
                case "/close": {
                    isReadyToClose = true;
                    out.close();
                    s.close();
                    executor.shutdown();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Failed respond to client request: " + e.getMessage());
        }
        return;
    }

    private void getFeed(Socket s, PrintWriter out) throws IOException {
        out.println("HTTP/1.0 200");
        out.println("Content-type: text/html");
        out.println("Server-name: myserver");
        String response = "<html>"
                + "<head>"
                + "<title>My Web Server</title></head>"
                + "<h1>Welcome to my Web Server!</h1>"
                + "</html>";
        out.println("Content-length: " + response.length());
        out.println("");
        out.println(response);
        out.flush();
        out.close();
        s.close();
    }

    private void swapXmls(Socket s, PrintWriter out) throws IOException {
        // rename xml files as feedOld -> feedCurrent:
        // rename feedOld -> feedOld_temp
        // rename feedCurrent -> feedOld
        // rename feedTemp -> feedCurrent
        // TODO: Delete all this line below and remove arguments from the method.
        out.println("Xml swapped.");
        out.flush();
        out.close();
        s.close();
        System.out.println("Xml swapped.");
    }
}
