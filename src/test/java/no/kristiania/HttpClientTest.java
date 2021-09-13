package no.kristiania;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HttpClientTest {
    @Test
    void shouldReturnStatusCode() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", "/html", 80);
        assertEquals(200, client.getStatusCode());
    }

}