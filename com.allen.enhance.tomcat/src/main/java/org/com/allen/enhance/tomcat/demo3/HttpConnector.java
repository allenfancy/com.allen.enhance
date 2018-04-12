package org.com.allen.enhance.tomcat.demo3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpConnector implements Runnable {

    boolean stopped;

    private String scheme = "http";

    @Override
    public void run() {
        ServerSocket ss = null;
        int port = 8080;
        try {
            ss = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        while (!stopped) {
            Socket socket = null;
            try {
                socket = ss.accept();
            }catch (Exception e) {
                continue;
            }
            HttpProcessor processor = new HttpProcessor(this);
            processor.process(socket);
        }
    }

    public String getScheme() {
        return scheme;
    }

    public void start() {
        Thread t = new Thread(this);
        t.start();
    }
}
