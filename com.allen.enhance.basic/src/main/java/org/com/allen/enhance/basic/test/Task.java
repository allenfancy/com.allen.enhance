package org.com.allen.enhance.basic.test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.common.collect.Lists;

/**
 * @author allen.wu
 * @since 2020-02-22 10:11
 */
public class Task implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private List<String> params;
    private String url;

    public Task(CyclicBarrier cyclicBarrier, List<String> params, String url) {
        this.cyclicBarrier = cyclicBarrier;
        this.params = params;
        this.url = url;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
            for (String param : this.params) {
                testGet(param);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testGet(String param) throws IOException {
        HttpGet httpGet;
        try {
            List<NameValuePair> nvps = Lists.newArrayList();
            nvps.add(new BasicNameValuePair("token", param));
            nvps.add(new BasicNameValuePair("type", "json"));
            nvps.add(new BasicNameValuePair("appkey", "d4503b07e206ef45"));
            nvps.add(new BasicNameValuePair("ts", "" + System.currentTimeMillis() / 1000L));
            nvps.add(new BasicNameValuePair("sign", ApiSignHelper.getSign(nvps, "c9a6f3e01f21c46daf548590df979aeb")));
            String queryString = EntityUtils.toString(new UrlEncodedFormEntity(nvps, "UTF-8"));
            httpGet = new HttpGet(String.format("?%s", url, queryString));
            HttpClient httpClient = HttpClients.createDefault();
            HttpResponse response = httpClient.execute(httpGet);
            String content = EntityUtils.toString(response.getEntity());
            System.out.println(content);
        } catch (Exception e) {
            // ignore
        }
    }
}
