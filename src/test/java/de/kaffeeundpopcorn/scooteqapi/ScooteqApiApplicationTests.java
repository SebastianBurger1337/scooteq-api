package de.kaffeeundpopcorn.scooteqapi;

import de.kaffeeundpopcorn.scooteq.controller.ApiController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScooteqApiApplicationTests {

	@Autowired
	public ApiController apiController;

	@Test
	public void contextLoads() {
	}

}
