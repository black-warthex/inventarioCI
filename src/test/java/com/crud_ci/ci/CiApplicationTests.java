package com.crud_ci.ci;

import com.crud_ci.ci.controller.InventarioController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(InventarioController.class)
@RunWith(SpringRunner.class)
class CiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHello()throws Exception{
		mockMvc.perform(get("/inv/get")).andExpect(status().isNotFound());
	}

}
