package com.example.algorithm.Executor;

import javax.xml.bind.Element;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.*;

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

    /**
     * 创建一个固定大小的线程池，并采用有界队列以及”调用者运行“饱和策略
     */
    public void createExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public void processSequentially(List<Element> elements) {
        for (Element el :
                elements) {
            process(el);
        }
    }

    public void processInParallel(Executor exec, List<Element> elements) {
        for (final Element el : elements)
            exec.execute(() -> process(el));
    }

    private void process(Element el) {
    }
}
