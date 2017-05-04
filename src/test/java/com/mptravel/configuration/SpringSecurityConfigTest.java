package com.mptravel.configuration;

import com.mptravel.user.controller.UserController;
import com.mptravel.user.service.BasicUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class SpringSecurityConfigTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BasicUserService basicUserService;

    @Test
    public void testLoginWithValidParameters_ShouldLogin() throws Exception {
        this.mvc
                .perform(formLogin().user("test1").password("123456"))
                .andExpect(status().is3xxRedirection())
                .andExpect(authenticated().withUsername("test1"));
    }

    @Test
    public void testLoginWithInvalidParameters_ShouldNotLogin() throws Exception {
        this.mvc
                .perform(formLogin().user("test1").password("wrongPassword"))
                .andExpect(status().is3xxRedirection())
                .andExpect(unauthenticated());
    }

    @Configuration
    static class TestSpringConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .inMemoryAuthentication()
                    .withUser("test1")
                    .password("123456")
                    .roles("USER");
        }
    }
}
