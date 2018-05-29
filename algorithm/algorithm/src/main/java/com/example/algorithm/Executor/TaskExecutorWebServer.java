package com.example.algorithm.Executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutorWebServer {
    private static final int NTHREADS = 100;
    //初始化线程池大小
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    /**
     * 基于线程池的web服务器.
     */
    public static void threadMain() {
        try {
            ServerSocket serverSocket = new ServerSocket(80);
            while (true) {
                final Socket socket = serverSocket.accept();
                Runnable task = () -> handelRequest(socket);
                exec.execute(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handelRequest(Socket socket) {
        System.out.println(socket.getPort() + "---name");
    }

    public static void main(String[] args) {
        threadMain();
    }
}
