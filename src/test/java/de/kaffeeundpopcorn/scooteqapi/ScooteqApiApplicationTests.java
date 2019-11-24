package de.kaffeeundpopcorn.scooteqapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.kaffeeundpopcorn.scooteqapi.controller.ApiController;
import de.kaffeeundpopcorn.scooteqapi.model.Customer;
import de.kaffeeundpopcorn.scooteqapi.repository.CustomerRepository;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ScooteqAPI.class, ApiController.class})
@AutoConfigureMockMvc
@WebMvcTest(ApiController.class)
public class ScooteqApiApplicationTests
{

	@Autowired
	private ApiController apiController;
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CustomerRepository customerRepository;

	private Customer testCustomer = new Customer()
	{{
		setFirstName("Dummy");
		setLastName("Training");
		setCustomerId(1L);
		setDriversLicense(true);
		setAddress("Dummystraße 1");
		setCity("Dummington");
		setPostalCode("12345");
		setCountry("Germany");
		setBirthDate(Date.valueOf("1990-10-03"));

	}};

	public static Object asObject(String json) {
		try {
			return new ObjectMapper().readValue(json, Customer.class);
		} catch (Exception e) {
			return null;
		}
	}

	public static String asJsonString(final Object obj)
	{
		try
		{
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	@Test
	public void contextLoads()
	{
		assertThat(apiController).isNotNull();
	}

	@Test
	public void testHealth() throws Exception
	{
		mockMvc.perform(get("/v1/health"))
				.andExpect(status().isOk());
	}

	@Test
	public void testCreateCustomer() throws Exception
	{
		mockMvc.perform(post("/v1/customer")
				.content(asJsonString(testCustomer))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
