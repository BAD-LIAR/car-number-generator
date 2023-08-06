package ru.gvozdev.numbergenerator;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@SpringBootTest
class NumberGeneratorApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void nextNumberGenerated()
            throws ClientProtocolException, IOException {

        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/number/next");

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        // Then
        MatcherAssert.assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void randomNumberGenerated()
            throws ClientProtocolException, IOException {

        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/number/random");

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        // Then
        MatcherAssert.assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_OK));
    }

}
