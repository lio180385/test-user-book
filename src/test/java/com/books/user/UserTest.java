package com.books.user;

import org.junit.Assert;

import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.books.user.model.User;

@SpringBootTest
public class UserTest {
	RestTemplate restTemplate = new RestTemplate();
	@Test
	public void testCreateUser() {
		 
			
			User user = new User();
			user.setUsername("admin@gmail.com");
			ResponseEntity<User> postResponse = restTemplate.postForEntity("http://localhost:8089/users", user, User.class);
			Assert.assertNotNull(postResponse);
			Assert.assertNotNull(postResponse.getBody());
		}
	@Test
	public void testGetAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8089/users",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}

	
	@Test
	public void testGetUserById() {
		User user = restTemplate.getForObject("http://localhost:8089/users/1", User.class);
		System.out.println(user.getUsername());
		Assert.assertNotNull(user);
	}

	
	@Test
	public void testUpdatePost() {
		long id = 1;
		User user = restTemplate.getForObject("http://localhost:8089/users/" + id, User.class);
		user.setUsername("Leo");
		restTemplate.put("http://localhost:8089/users/" + id, user);
				 
		User updatedUser = restTemplate.getForObject("http://localhost:8089/users/" + id, User.class);
		Assert.assertNotNull(updatedUser);
		
		
		
		
	}

	@Test
	public void testDeletePost() {
		int id = 5;
		User user = restTemplate.getForObject("http://localhost:8089/users/" + id, User.class);
		Assert.assertNotNull(user);

		restTemplate.delete("http://localhost:8089/user/" + id);

		try {
			user = restTemplate.getForObject("http://localhost:8089/users/" + id, User.class);
		} catch (final HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
