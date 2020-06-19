package com.assesment.cognizant.api.rest.test;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import com.assesment.cognizant.api.rest.CarController;
import com.assesment.cognizant.dao.jpa.GarageRepository;
import com.assesment.cognizant.domain.Cars;
import com.assesment.cognizant.service.CarService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc

public class CarControllerTest  {

	   protected MockMvc mvc;
	   @Autowired
	   WebApplicationContext webApplicationContext;

	   protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	   
	   protected String mapToJson(Object obj) throws JsonProcessingException {
		      ObjectMapper objectMapper = new ObjectMapper();
		      return objectMapper.writeValueAsString(obj);
		   }
		   protected <T> T mapFromJson(String json, Class<T> clazz)
		      throws JsonParseException, JsonMappingException, IOException {
		      
		      ObjectMapper objectMapper = new ObjectMapper();
		      return objectMapper.readValue(json, clazz);
		   }
		   
	   @Test
	   public void getCarsList() throws Exception {
	      String uri = "/api/v1/cars";
	      mvc.perform(get(uri)).andExpect(status().isOk());
	      /*MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Cars[] productlist = mapFromJson(content, Cars[].class);
	      assertTrue(productlist.length > 0);*/
	   }
	
	/*@Test
	public void testCars() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mockMvc.perform(get("/api/v1/cars")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.carMake").value("Volkswagen")).andExpect(jsonPath("$.carModel").value("Jetta III"))
				.andExpect(jsonPath("$.carYearModel").value(1995)).andExpect(jsonPath("$.carPrice").value(12947.52))
				.andExpect(jsonPath("$.carLicensed").value(true))
				.andExpect(jsonPath("$.date_added").value(new Date("2018-08-18")))
				.andExpect(jsonPath("$.warehouseName").value("Warehouse A"))
				.andExpect(jsonPath("$.warehouseLocation").value("Bangalore"));

	}*/
}
