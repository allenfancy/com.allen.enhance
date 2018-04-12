package com.allen.enhance.zipkin.config;

import brave.Tracing;
import brave.context.log4j2.ThreadContextCurrentTraceContext;
import brave.http.HttpTracing;
import brave.httpclient.TracingHttpClientBuilder;
import brave.okhttp3.TracingInterceptor;
import brave.propagation.B3Propagation;
import brave.propagation.ExtraFieldPropagation;
import brave.servlet.TracingFilter;
import brave.spring.web.TracingClientHttpRequestInterceptor;
import brave.spring.webmvc.TracingHandlerInterceptor;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Configuration
@Import({TracingClientHttpRequestInterceptor.class, RestTemplate.class,
        TracingHandlerInterceptor.class})
public class TracingConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private ZipkinProperties properties;

    @Bean
    public Sender sender() {
        return OkHttpSender.create(properties.getEndpoint());
    }

    @Bean
    public AsyncReporter<zipkin2.Span> spanAsyncReporter() {
        return AsyncReporter.create(sender());
    }

    @Bean
    public Tracing tracing() {
        return Tracing.newBuilder().localServiceName(properties.getServiceName())
                .propagationFactory(
                        ExtraFieldPropagation.newFactory(B3Propagation.FACTORY, "USER-NAME"))
                .currentTraceContext(ThreadContextCurrentTraceContext.create())
                .spanReporter(spanAsyncReporter()).build();
        //return null;
    }

    /**
     * @Desc HTTP
     * @param tracing
     * @return
     */
    @Bean
    public HttpTracing httpTracing(Tracing tracing) {
        return HttpTracing.create(tracing);
    }

    /**
     * @Desc ADD Servlet Filter
     * @param tracing
     * @return
     */
    @Bean
    public TracingFilter tracingFilter(Tracing tracing) {
        return (TracingFilter) TracingFilter.create(tracing);
    }

    /**
     * @Desc HttpClient
     * @param tracing
     * @return
     */
    @Bean
    public TracingHttpClientBuilder tracingHttpClientBuilder(Tracing tracing) {
        return (TracingHttpClientBuilder) TracingHttpClientBuilder.create(tracing);
    }

    /**
     * @Desc OKHttpClient
     * @param tracing
     * @return
     */
    @Bean
    public OkHttpClient okHttpClient(Tracing tracing) {
        HttpTracing httpTracing = HttpTracing.create(tracing);
        Interceptor interceptor = TracingInterceptor.create(httpTracing);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    /**
     * @Desc Spring MVC
     */
    @Autowired
    private TracingHandlerInterceptor tracingHandlerInterceptor;

    /**
     * @Desc Spring web
     *
     */
    @Autowired
    private TracingClientHttpRequestInterceptor tracingClientHttpRequestInterceptor;


    @Autowired
    public RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        List<ClientHttpRequestInterceptor> interceptors =
                new ArrayList<ClientHttpRequestInterceptor>(restTemplate.getInterceptors());
        interceptors.add(tracingClientHttpRequestInterceptor);
        restTemplate.setInterceptors(interceptors);
    }

    /**
     * @Desc adds tracing to the application-defined web controller
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tracingHandlerInterceptor);
    }
}
