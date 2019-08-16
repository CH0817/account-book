package com.rex.accountbook.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {PageController.class})
@AutoConfigureMockMvc
public class PageControllerTest {

    @Autowired
    protected MockMvc mvc;

    @Test
    public void securityLoginPageRedirect() throws Exception {
        mvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(result -> {
                    String redirectedUrl = result.getResponse().getRedirectedUrl();
                    assertEquals("/login", redirectedUrl.substring(redirectedUrl.lastIndexOf("/")));
                });
    }

    @Test
    public void loginPage() throws Exception {
        mvc.perform(get("/login"))
                .andDo(print())
                .andExpect(view().name("login"));
    }

}
