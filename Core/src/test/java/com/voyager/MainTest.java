package com.voyager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
@RunWith(SpringRunner.class)
public class MainTest {
    protected static final Logger log = LogManager.getLogger(MainTest.class);

    @Test
    @Ignore
    public void test() {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity test = restTemplate.exchange("http://localhost:8080/test",
                HttpMethod.GET,
                new HttpEntity<String>(createHeaders("voyager", "nenimdada")),
                String.class);
        log.info(test.getBody());
        assertNotNull(test.getBody());
    }

    HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("utf-8")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }
}


