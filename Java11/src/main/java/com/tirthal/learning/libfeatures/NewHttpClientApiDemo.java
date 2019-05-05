package com.tirthal.learning.libfeatures;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * The standardized HTTP client API is for the replacement of the legacy HttpUrlConnection class (which has been present
 * in the JDK since the very early years of Java)
 * <p>
 * The new API supports both HTTP/1.1 and HTTP/2. The newer version of the HTTP protocol is designed to improve the
 * overall performance of sending requests by a client and receiving responses from the server. This is achieved
 * by introducing a number of changes, such as stream multiplexing, header compression, and push promises.
 * In addition, the new HTTP client also natively supports WebSockets.
 *
 * See [1](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html)
 */
public class NewHttpClientApiDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Specifying the HTTP Protocol Version
        var httpClient = HttpClient.newBuilder()
                                   .version(HttpClient.Version.HTTP_2)
                                   .build();


        // Creating a GET Request
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create("https://reqres.in/api/users/2"))
                                         .GET()
                                         .build();

        // Synchronously Sending an HTTP Request
        sendSyncHttpReq(httpClient, request);

        // Asynchronously Sending an HTTP Request
        sendAsyncHttpReq(httpClient, request);

        Thread.sleep(5*1000);
    }

    private static void sendSyncHttpReq(HttpClient httpClient, HttpRequest request) throws IOException, InterruptedException {
        System.out.println("====== Synchronous Example");
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response status code: " + response.statusCode());
        System.out.println("Response headers: " + response.headers());
        System.out.println("Response body: " + response.body());
    }

    private static void sendAsyncHttpReq(HttpClient httpClient, HttpRequest request) {
        System.out.println("====== Asynchronous Example");
        // Here, sendAsync would return a CompletableFuture<HttpResponse<String>>
        // The thenAccept method adds a Consumer to be triggered when the response is available
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    System.out.println("Response status code: " + response.statusCode());
                    System.out.println("Response headers: " + response.headers());
                    System.out.println("Response body: " + response.body());
                });
    }
}
