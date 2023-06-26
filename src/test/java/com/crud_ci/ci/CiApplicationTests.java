package com.crud_ci.ci;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
class CiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHello()throws Exception{
		assertEquals(1,1);
	}

}
