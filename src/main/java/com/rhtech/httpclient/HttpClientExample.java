package com.rhtech.httpclient;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.URI;

public class HttpClientExample {
    public static void blockingModeRequestHttp1_1() throws IOException, InterruptedException {
        HttpClient client =
                HttpClient.newBuilder()
                        .version(HttpClient.Version.HTTP_2)
                        .followRedirects(HttpClient.Redirect.ALWAYS)
                        .build();

        HttpRequest request =
                HttpRequest.newBuilder(URI.create("http://www.google.com")).GET().build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandler.asString()); // Blocking Mode

        // System.out.println(response.body());
        System.out.println(response.statusCode()); // 200 OK
        System.out.println(response.version()); // HTTP_1_1
    }

    public static void nonblockingModeRequestHttp1_1() throws IOException, InterruptedException {

        HttpClient client =
                HttpClient.newBuilder()
                        .version(HttpClient.Version.HTTP_2)
                        .followRedirects(HttpClient.Redirect.ALWAYS).build();

        HttpRequest request =
                HttpRequest.newBuilder(URI.create("http://www.google.com")).GET().build();

        client.sendAsync(request, HttpResponse.BodyHandler.asString())
                .thenAccept(
                        (response) -> {
                            System.out.println(response.statusCode()); // HTTP_1_1
                            System.out.println(response.version());
                        })
                .join(); // making it blocking

    }

    public static void main(String[] args) throws IOException, InterruptedException {

        // blockingModeRequestHttp1_1();
        nonblockingModeRequestHttp1_1();

    }
}
