package com.cts.wt.projectmanager.backend.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cts.wt.projectmanager.backend.entities.Project;
import com.cts.wt.projectmanager.backend.entities.Task;
import com.cts.wt.projectmanager.backend.entities.User;
import com.cts.wt.projectmanager.backend.entities.User;
import com.cts.wt.projectmanager.backend.repos.UserRepo;
import com.cts.wt.projectmanager.backend.repos.UserRepo;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	UserRepo userRepo;

	User mockUser = new User ();
	
	List<User> mockUsers = new ArrayList<User>();
	
	

	
	
	@Test
	public void fetchAllUserTest() throws Exception {

		mockUser();
		
		Mockito.when(
				userRepo.findAll()).thenReturn(mockUsers);

			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/user").accept(
					MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			assertNotNull(result.getResponse().getStatus());
	
	}
	
	@Test
	public void filterManagerTest() throws Exception {

		mockUser();

		Mockito.when(userRepo.findIdByName(mockUser.getFirstName())).thenReturn(mockUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/userName/Nilo").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getStatus());

	}

	
	
	@Test
	public void fetchUserTest() throws Exception {

		mockUser();

		Mockito.when(userRepo.findById(mockUser.getUserId())).thenReturn(mockUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getStatus());

	}
	
	@Test
	public void deleteUserTest() throws Exception {

		mockUser();
		
		Mockito.when(
				userRepo.findById(mockUser.getUserId())).thenReturn(mockUser);
		
			RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(
					"/user/1").accept(
					MediaType.APPLICATION_JSON);
			
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			assertEquals(HttpStatus.OK.value(), response.getStatus());
	
	}
	
	

	@Test
	public void addUserTest() throws Exception {
		String userJson = "{\"firstName\":\"Nilo\"}";
		mockUser();
				Mockito.when(
						userRepo.save(
								Mockito.any(User.class))).thenReturn(mockUser);
		
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/user")
					.accept("*").content(userJson)
					.contentType(MediaType.APPLICATION_JSON);
			
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			assertNotNull(response.getStatus());
	
	}
	
	
	@Test
	public void updatetUserTest() throws Exception {
		String userJson = "{\"userId\":\"1\",\"firstName\":\"Nilo\"}";
		mockUser();
				Mockito.when(
						userRepo.save(
								Mockito.any(User.class))).thenReturn(mockUser);
		
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.put("/user").accept("*").content(userJson)
					.contentType(MediaType.APPLICATION_JSON);
			
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			assertNotNull(response.getStatus());
	
	}
	
	@Test
	public void updatetUserProjectTest() throws Exception {
		String userJson = "{\"userId\":\"1\",\"firstName\":\"Nilo\"}";
		mockUser();
				Mockito.when(
						userRepo.save(
								Mockito.any(User.class))).thenReturn(mockUser);
		
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.put("/user/project").accept("*").content(userJson)
					.contentType(MediaType.APPLICATION_JSON);
			
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			assertNotNull(response.getStatus());
	
	}


	/** Sets up mock Data
	 * 
	 */
	private void mockUser() {
		Task t = new Task();
		t.setTaskId(2);
		Project p = new Project();
		p.setProjectId(3);
		mockUser.setUserId(1);
		mockUser.setTask(t);
		mockUser.setProject(p);
		mockUser.setFirstName("Nilo");
		mockUser.setLastName("NA");
		mockUser.setEmployeeId("102345");
		mockUsers.add(mockUser);
	}

}
