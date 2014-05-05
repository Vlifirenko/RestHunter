package resthunter.rest;

import android.util.Log;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Created by gorodechnyj on 15.02.14.
 */
public class LoggingInterceptor implements ClientHttpRequestInterceptor {
    private static final String TAG = "com.fupmstma.rest.LoggingInterceptor";

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] data, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        // the following code consumes body of response. Don't know how to avoid it.
//        ClientHttpResponse response = clientHttpRequestExecution.execute(request, data);
//        java.util.Scanner s = new java.util.Scanner(response.getBody()).useDelimiter("\\A");
//        String responseBody = s.hasNext() ? s.next() : "";
//        Log.d(TAG, responseBody);
//        return response;
        Log.d(TAG, "To     : " + request.getURI());
        Log.d(TAG, "Method : " + request.getMethod().name());
        Log.d(TAG, "Data   : " + new String(data));

        for (Object key : request.getHeaders().keySet()) {
            Log.d(TAG, "Header <" + key + ">: " + request.getHeaders().get(key));
        }
        Log.d(TAG, "Body: " + new String(data, "UTF-8"));

        final ClientHttpResponse response = clientHttpRequestExecution.execute(request, data);

//        if (response != null) {
//            Log.d(TAG, "Response: " + response.getStatusCode());
//            if (response.getBody() != null) {
//                Log.d(TAG, "Response: " + IOUtils.toString(response.getBody(), "UTF-8"));
//            }
//        } else {
//            Log.d(TAG, "Response: " + response);
//        }
        return response;
    }
}
