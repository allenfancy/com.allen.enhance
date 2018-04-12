package org.com.allen.enhance.tomcat.demo3;

import java.net.Socket;

public class HttpProcessor {

    private HttpConnector connector;

    public HttpProcessor(HttpConnector connector) {
        this.connector = connector;
    }


    public void process(Socket socket) {

    }
}
