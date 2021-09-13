package no.kristiania;

import java.io.IOException;
import java.net.Socket;

public class HttpClient {

    int statusCode = 200;

    public HttpClient(final String host, final String request, int port) throws IOException {
        Socket socket = new Socket(host, port);
        socket.getOutputStream().write(("GET /" + request + " HTTP/1.1\r\n" +
                "Host: " + host + " \r\n" +
                "\r\n").getBytes());

        int c;
        while ((c = socket.getInputStream().read()) != -1) {
            if (c != '\n') break;
            System.out.print((char) c);
        }
    }

    public static void main(String[] args) throws IOException {
        HttpClient client = new HttpClient("httpbin.org", "/html", 80);
    }

    public int getStatusCode() {

        return statusCode;
    }
}
