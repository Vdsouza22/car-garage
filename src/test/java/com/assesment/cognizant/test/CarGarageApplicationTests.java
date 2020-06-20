package com.assesment.cognizant.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.assesment.cognizant.CarGarageApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarGarageApplication.class)
@AutoConfigureMockMvc
public class CarGarageApplicationTests {

	@Test
	public void contextLoads() {
		
	}

}
