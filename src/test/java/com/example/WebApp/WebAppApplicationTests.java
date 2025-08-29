//package com.example.WebApp;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class WebAppApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}



package com.example.WebApp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class WebAppApplicationTests {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void shouldReturnDefaultMessage() throws Exception {
//        this.mockMvc.perform(get("/"))
//            .andDo(print())
//            .andExpect(status().isOk())
//            .andExpect(content().string(containsString("Hello, World!")));
//    }

    @Test
    public void shouldReturnGreetingForAnderson() throws Exception {
        this.mockMvc.perform(get("/Anderson"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("Hello, Anderson!"));
    }

    @Test
    public void testSomaEndpoint() throws Exception {
        this.mockMvc.perform(get("/soma").param("a", "2").param("b", "3"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("Resultado: 5"));
    }

    @Test
    public void testBoasVindasEndpoint() throws Exception {
        this.mockMvc.perform(get("/boasvindas").param("nome", "Fulano"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("Bem-vindo(a), Fulano!"));
    }

    @Test
    public void testSaudacao() throws Exception {
        this.mockMvc.perform(get("/saudacao").param("nome", "Anderson"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Anderson")));
    }

    @Test
    public void testSobreEndpoint() throws Exception {
        this.mockMvc.perform(get("/sobre"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("Projeto GCMS - Prática 03"));
    }

    //teste quebra proposital para Git Actions
    @Test
    public void testHotfixEndpointMain() throws Exception {
        this.mockMvc.perform(get("/hotfix"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("Hotfix!"));
    }

}
