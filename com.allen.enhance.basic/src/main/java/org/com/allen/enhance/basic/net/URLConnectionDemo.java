package org.com.allen.enhance.basic.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author allen.wu
 * @since 2018-07-20 16:59
 */
public class URLConnectionDemo {


    public static void main(String[] args) throws IOException {

        URL url = new URL("https", "115.239.210.27", 443,"");
        URLConnection urlConnection = new HttpURLConnection(url) {
            @Override
            public void disconnect() {
                System.out.println("关闭连接");
            }

            @Override
            public boolean usingProxy() {
                return false;
            }

            @Override
            public void connect() throws IOException {
                System.out.println("开始连接");
            }
        };
        urlConnection.connect();
        ((HttpURLConnection) urlConnection).disconnect();
    }
}
