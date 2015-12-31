package pretest.board.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import pretest.Application;
import pretest.board.model.Document;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 2015. 12. 31.
 * Copyright by joyhan / HUFS
 * BoardRestController
 * 
 * Test는 간단하게 사용만 해봤습니다.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=9999")
public class BoardRestControllerTest {
	private Document document;

    @Autowired private WebApplicationContext wac;
    @Autowired private ObjectMapper objectMapper;
    private MockMvc mock;
 
    @Before
    public void setUp() throws Exception {
        this.mock = MockMvcBuilders.webAppContextSetup(wac).build();
        document = new Document();
        document.setEmail("yyh91@ca.com");
        document.setPassword("password");
        document.setContent("content");
    }
 
    @Test
    public void testInsertDocument() throws Exception {
        ResultActions resultActions =
                mock.perform(MockMvcRequestBuilders.post("/boards").param("email",document.getEmail())
                		.param("password", document.getPassword())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED));
 
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("board"));
    }
 
}
