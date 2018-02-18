package com.mars.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mars.MarsApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarsApplication.class)
@AutoConfigureMockMvc
public class MarsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnATextWith2x0xS() throws Exception {
		mockMvc.perform(post("/rest/mars/MMRMMRMM")).andExpect(status().isOk())
				.andExpect(content().string("(2, 0, S)"));
	}

	@Test
	public void shouldReturnATextWith0x2xSAfter2Calls() throws Exception {
		mockMvc.perform(post("/rest/mars/MML")).andExpect(status().isOk()).andExpect(content().string("(0, 2, W)"));

		mockMvc.perform(post("/rest/mars/MML")).andExpect(status().isOk()).andExpect(content().string("(0, 2, W)"));
	}

	@Test
	public void shouldReturnATextWithErroMessageWhenAreInvalidTokens() throws Exception {
		mockMvc.perform(post("/rest/mars/AAA")).andExpect(status().isBadRequest())
				.andExpect(content().string("400 Bad Request"));
	}

	@Test
	public void shouldReturnATextWithErroMessageWhenCoomandCanNotExecute() throws Exception {
		mockMvc.perform(post("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM")).andExpect(status().isBadRequest())
				.andExpect(content().string("400 Bad Request"));
	}

}