package com.assesment.cognizant.api.rest.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void getCarsTest() throws Exception {

		MvcResult result = mockMvc.perform(get("/api/v1/cars").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		Assert.assertTrue(result.getResponse().getStatus() == 200);

	}
	
	@Test
	public void getCarsByIdTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/v1/cars/2").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		Assert.assertTrue(result.getResponse().getStatus() == 200);

	}
	
	@Test
	public void getCarsByInvalidIdTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/v1/cars/10").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isNotFound()).andReturn();
		Assert.assertTrue(result.getResponse().getStatus() == 404);

	}
	
	@Test
	public void getCarsByInvalidUrlTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/v1/cars2").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isNotFound()).andReturn();
		Assert.assertTrue(result.getResponse().getStatus() == 404);

	}
	

}
