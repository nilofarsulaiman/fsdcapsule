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

import com.cts.wt.projectmanager.backend.entities.ParentTask;
import com.cts.wt.projectmanager.backend.repos.ParentTaskRepo;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ParentTaskController.class, secure = false)
public class ParentTaskControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ParentTaskRepo parentTaskRepo;

	ParentTask mockParentTask = new ParentTask ();
	
	ParentTaskController controller = new ParentTaskController();

	List<ParentTask> mockParentTasks = new ArrayList<ParentTask>();
	
	

	
	
	@Test
	public void fetchAllParentTaskTest() throws Exception {

		mockParentTask();
		
		Mockito.when(
				parentTaskRepo.findAll()).thenReturn(mockParentTasks);

			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/parentTask").accept(
					MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			String expected = "[{id:1,parentTask:Investments}]";
			JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);
	
	}
	
	
	@Test
	public void fetchParentTaskTest() throws Exception {

		mockParentTask();
		
		Mockito.when(
				parentTaskRepo.findById(mockParentTask.getId())).thenReturn(mockParentTask);

			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/parentTask/1").accept(
					MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			String expected = "{id:1,parentTask:Investments}";
			JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);
	
	}
	
	@Test
	public void deleteParentTaskTest() throws Exception {

		mockParentTask();
		
		Mockito.when(
				parentTaskRepo.findById(mockParentTask.getId())).thenReturn(mockParentTask);
		
			RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(
					"/parentTask/1").accept(
					MediaType.APPLICATION_JSON);
			
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			assertEquals(HttpStatus.OK.value(), response.getStatus());
	
	}
	
	

	@Test
	public void addParentTaskTest() throws Exception {
		String parentTaskJson = "{\"parentTask\":\"Investments\"}";
		mockParentTask();
				Mockito.when(
						parentTaskRepo.save(
								Mockito.any(ParentTask.class))).thenReturn(mockParentTask);
		
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/parentTask")
					.accept("*").content(parentTaskJson)
					.contentType(MediaType.APPLICATION_JSON);
			
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			assertNotNull(response.getStatus());
	
	}
	
	
	@Test
	public void updateParentTaskTest() throws Exception {
		String parentTaskJson = "{\"id\":\"1\",\"parentTask\":\"Contributions\"}";
		mockParentTask();
				Mockito.when(
						parentTaskRepo.save(
								Mockito.any(ParentTask.class))).thenReturn(mockParentTask);
		
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.put("/parentTask").accept("*").content(parentTaskJson)
					.contentType(MediaType.APPLICATION_JSON);
			
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			assertNotNull(response.getStatus());
	
	}


	/** Sets up mock Data
	 * 
	 */
	private void mockParentTask() {
		mockParentTask.setId(1);
		mockParentTask.setParentTask("Investments");
		mockParentTasks.add(mockParentTask);
	}

}
