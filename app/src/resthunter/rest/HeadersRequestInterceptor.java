package resthunter.rest;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Created by gorodechnyj on 15.02.14.
 */
public class HeadersRequestInterceptor implements ClientHttpRequestInterceptor {
    private static final String TAG = "com.fupmstma.rest.LoggingInterceptor";

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] data, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        request.getHeaders().set("Connection", "Close");
        return clientHttpRequestExecution.execute(request, data);
    }
}
