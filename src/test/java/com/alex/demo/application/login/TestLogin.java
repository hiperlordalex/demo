package com.alex.demo.application.login;

import com.alex.demo.modell.user.User;
import com.alex.demo.modell.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
public class TestLogin {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testLogin() throws Exception {

        User.Builder builder = User.builder();
        builder.emailAddess("test").password("test").userName("test");

        userRepository.save(User.create(builder));

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("emailAddess", "test");
        params.add("password", "test");

        mockMvc.perform(post("/login").params(params)).andExpect(status().isOk());
    }

}
