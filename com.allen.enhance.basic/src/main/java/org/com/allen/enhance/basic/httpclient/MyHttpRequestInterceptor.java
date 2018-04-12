package org.com.allen.enhance.basic.httpclient;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;


public class MyHttpRequestInterceptor implements HttpRequestInterceptor{

	@Override
	public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
		System.out.println("开始请求了 。。。。"+request.getRequestLine().getMethod());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
