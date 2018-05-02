package org.com.allen.enhance.basic.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class FastRegMain {


    private static final String PASSPORT = "";
    
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();


    public static void main(String[] args) {

    }


    public static void doSendSms() {

    }


    public static void doReg() {

    }

    public static String doPost(String url, String uri, String params)
            throws ClientProtocolException, IOException {
        String all = url + uri + "?" + params;
        System.out.println(all);
        HttpPost post = new HttpPost(all);
        CloseableHttpResponse execute = httpClient.execute(post);
        if (execute.getStatusLine().getStatusCode() == 200) {
            String str = EntityUtils.toString(execute.getEntity());
            System.out.println(uri + ",response : " + str);
            return str;
        }
        return "";
    }
}
