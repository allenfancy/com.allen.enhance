package org.com.allen.enhance.basic.test;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.List;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ParseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.common.collect.Lists;

import io.netty.channel.ConnectTimeoutException;

/**
 * @author allen.wu
 * @since 2020-02-22 11:57
 */
public class HttpClientUtils {

    private static final PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();

    static {
        connManager.setMaxTotal(1000);
        connManager.setDefaultMaxPerRoute(400);

    }

    /**
     * 获取Http客户端连接对象
     *
     * @return Http客户端连接对象
     */
    private static CloseableHttpClient getHttpClient() {
        // 创建Http请求配置参数
        RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(200)
            .setConnectTimeout(200)
            .setSocketTimeout(200)
            .build();

        HttpRequestRetryHandler retry = (exception, executionCount, context) -> {
            if (executionCount >= 1) {// 如果已经重试了3次，就放弃
                return false;
            }
            if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试
                return true;
            }
            if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常
                return false;
            }
            if (exception instanceof InterruptedIOException) {// 超时
                return true;
            }
            if (exception instanceof UnknownHostException) {// 目标服务器不可达
                return false;
            }
            if (exception instanceof ConnectTimeoutException) {// 连接被拒绝
                return false;
            }
            if (exception instanceof SSLException) {// ssl握手异常
                return false;
            }
            HttpClientContext clientContext = HttpClientContext.adapt(context);
            HttpRequest request = clientContext.getRequest();
            // 如果请求是幂等的，就再次尝试
            if (!(request instanceof HttpEntityEnclosingRequest)) {
                return true;
            }
            return false;
        };
        return HttpClients.custom()
            .setDefaultRequestConfig(requestConfig)
            .setRetryHandler(retry)
            .setConnectionManager(connManager)
            .build();
    }

    public static String get(String url, String line) {
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        String msg = "";
        try {
            List<NameValuePair> nvps = Lists.newArrayList();
            nvps.add(new BasicNameValuePair("token", line));
            nvps.add(new BasicNameValuePair("type", "json"));
            nvps.add(new BasicNameValuePair("appkey", "d4503b07e206ef45"));
            nvps.add(new BasicNameValuePair("ts", "" + System.currentTimeMillis() / 1000L));
            nvps.add(new BasicNameValuePair("sign", ApiSignHelper.getSign(nvps, "c9a6f3e01f21c46daf548590df979aeb")));
            String queryString = EntityUtils.toString(new UrlEncodedFormEntity(nvps, "UTF-8"));
            HttpGet httpGet = new HttpGet(String.format("%s?%s", url, queryString));
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            msg = EntityUtils.toString(entity, "UTF-8");
            // System.out.println(msg);
        } catch (ParseException | IOException ignored) {
        } finally {
            if (null != response) {
                try {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                } catch (IOException ignored) {
                }
            }
        }
        return msg;
    }

    public static String post(String url, String title, String msg, String email) {
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        try {
            List<NameValuePair> nvps = Lists.newArrayList();
            nvps.add(new BasicNameValuePair("appkey", "d4503b07e206ef45"));
            nvps.add(new BasicNameValuePair("title", title));
            nvps.add(new BasicNameValuePair("msg", msg));
            nvps.add(new BasicNameValuePair("email", title));
            nvps.add(new BasicNameValuePair("ts", "" + System.currentTimeMillis() / 1000L));
            nvps.add(new BasicNameValuePair("sign", ApiSignHelper.getSign(nvps, "c9a6f3e01f21c46daf548590df979aeb")));
            String queryString = EntityUtils.toString(new UrlEncodedFormEntity(nvps, "UTF-8"));
            HttpPost httpGet = new HttpPost(String.format("%s?%s", url, queryString));
            System.out.println(String.format("%s?%s", url, queryString));
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, "UTF-8");
        } catch (ParseException | IOException ignored) {
        } finally {
            if (null != response) {
                try {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                } catch (IOException ignored) {
                }
            }
        }
        return "";
    }

}
