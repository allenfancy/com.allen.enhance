package org.com.allen.enhance.basic.httpclient;

import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultBackoffStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;

public class SpringRestTemplate {

	private static int maxConnectNum = 800;
	private static int connTimeOut = 50;
	private static int readTimeOut = 200;

	private static CloseableHttpClient httpClient;

	private static HttpComponentsClientHttpRequestFactory requestFactory;

	private static RestTemplate restTemplate;

	static {
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(connTimeOut)
				.setConnectTimeout(connTimeOut).setSocketTimeout(readTimeOut).build();

		List<Header> defaultHeader = Lists.newArrayList();
		Header basicHeader = new BasicHeader("bili", "passport");
		defaultHeader.add(basicHeader);

		httpClient = HttpClientBuilder.create().addInterceptorFirst(new MyHttpRequestInterceptor())
				.addInterceptorFirst(new MyHttpResponseInterceptor()).setMaxConnTotal(maxConnectNum)
				.setDefaultHeaders(defaultHeader).setRetryHandler(new DefaultHttpRequestRetryHandler()) //  默认重试次数是3次
				.setConnectionBackoffStrategy(new DefaultBackoffStrategy())// 默认的backoff SocketException ConnectionException and Server 503
				.setConnectionReuseStrategy(new DefaultConnectionReuseStrategy()) // 连接重用策略 检测连接是否打开 如果打开继续使用
				//.setHttpProcessor(httpprocessor)
				.setDefaultRequestConfig(config).build();

		requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectionRequestTimeout(connTimeOut);
		requestFactory.setReadTimeout(readTimeOut);
		requestFactory.setHttpClient(httpClient);
		restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(requestFactory);
	}

	public static void main(String[] args) {
		ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8080", String.class);
		if (HttpStatus.SC_OK == forEntity.getStatusCode().OK.value()) {
			System.out.println(forEntity.getBody());
		}
	}
}
