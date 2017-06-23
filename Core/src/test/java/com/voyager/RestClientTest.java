package com.voyager;

import com.voyager.core.Application;
import com.voyager.core.repository.UserRepository;
import com.voyager.model.entity.Role;
import com.voyager.model.entity.User;
import com.voyager.model.entity.UserDetails;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

import static junit.framework.TestCase.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
public class RestClientTest {
    private static final Logger log = LogManager.getLogger(RestClientTest.class);
    private static final String testRestUrl = "http://localhost:8080/test/";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserRepository userRepository;
    @Autowired

    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    private MockMvc mockMvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }


    @Test
    @WithMockUser(username = "bodik@list.ru", password = "nenimdada", roles = "USER")
    public void registerNewUser() throws Exception {
        UserDetails userDetails = new UserDetails();
        userDetails.setLocale(Locale.ENGLISH);
        userDetails.setSex(UserDetails.Sex.MALE);

        User user = new User("bodik@list1.ru",
                new BCryptPasswordEncoder().encode("nenimdada"),
                Role.USER, true);
        user.setUserDetails(userDetails);

        mockMvc.perform(post("/user")
                .content(this.json(user))
                .headers(createHeaders(user.getUsername(), user.getPassword()))
                .param("user",this.json(user))
                .contentType(contentType))
                .andExpect(status().isCreated());
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

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
                new HttpEntity<String>(createHeaders("bodik@list.ru", "nenimdada")),
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

    public static class MockSecurityContext implements SecurityContext {

        private static final long serialVersionUID = -1386535243513362694L;

        private Authentication authentication;

        public MockSecurityContext(Authentication authentication) {
            this.authentication = authentication;
        }

        @Override
        public Authentication getAuthentication() {
            return this.authentication;
        }

        @Override
        public void setAuthentication(Authentication authentication) {
            this.authentication = authentication;
        }
    }
}


