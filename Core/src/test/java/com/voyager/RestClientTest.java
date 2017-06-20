package com.voyager;

import com.voyager.core.Application;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class RestClientTest {
    private static final Logger log = LogManager.getLogger(RestClientTest.class);
    private static final String testRestUrl = "http://localhost:8080/test/";

    @Value("${service.basicauth.login}")
    private String login;

    @Value("${service.basicauth.password}")
    private String password;

    @Test(expected = HttpClientErrorException.class)
    @Ignore
    public void restCallNoAuth() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(testRestUrl, String.class); //has to throw exception
        assertNotNull(null);
    }

    @Test
    @Ignore
    public void restCallwithBasicAuth() {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity test = restTemplate.exchange(testRestUrl,
                HttpMethod.GET,
                new HttpEntity<String>(createHeaders(login, password)),
                String.class);
        log.info(test.getBody());
        assertNotNull(test.getBody());
    }


    HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("utf-8")));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }
}


