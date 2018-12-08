package com.cts.wt.projectmanager.backend.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
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
import com.cts.wt.projectmanager.backend.entities.Task;
import com.cts.wt.projectmanager.backend.repos.ParentTaskRepo;
import com.cts.wt.projectmanager.backend.repos.TaskRepo;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TaskController.class, secure = false)
public class TaskControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ParentTaskRepo parentTaskRepo;

	@MockBean
	TaskRepo taskRepo;

	Task mockTask = new Task();

	List<Task> mockTasks = new ArrayList<Task>();
	
	ParentTask mockParentTask = new ParentTask ();

	@Test
	public void fetchTaskByProjectTest() throws Exception {

		mockTask();

		Mockito.when(taskRepo.findTaskByProject(mockTask.getProjectId())).thenReturn(mockTasks);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/tasks/3").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getStatus());

	}

	@Test
	public void fetchCompletedProjectTest() throws Exception {

		mockTask();

		Mockito.when(taskRepo.findAllCompletedProject()).thenReturn(mockTasks);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/tasks").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getStatus());

	}

	@Test
	public void fetchAllTaskTest() throws Exception {

		mockTask();

		Mockito.when(taskRepo.findAll()).thenReturn(mockTasks);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/task").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getStatus());

	}

	@Test
	public void fetchTaskTest() throws Exception {

		mockTask();

		Mockito.when(taskRepo.findById(mockTask.getTaskId())).thenReturn(mockTask);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/task/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getStatus());

	}

	@Test
	public void deleteProjectTest() throws Exception {

		mockTask();

		Mockito.when(taskRepo.findById(mockTask.getTaskId())).thenReturn(mockTask);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/task/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	@Test
	public void addProjectTest() throws Exception {
		String taskJson = "{\"projectId\":\"3\",\"startDate\":\"2019-11-01\"}";
		mockTask();

        mockParentTask();
		
		Mockito.when(
				parentTaskRepo.findById(mockParentTask.getId())).thenReturn(mockParentTask);
		Mockito.when(taskRepo.save(Mockito.any(Task.class))).thenReturn(mockTask);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/task").accept("*").content(taskJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertNotNull(response.getStatus());

	}

	@Test
	public void updateProjectTest() throws Exception {
		String taskJson = "{\"taskId\":\"1\",\"projectId\":\"3\",\"startDate\":\"2019-11-01\"}";
		mockTask();
		Mockito.when(taskRepo.save(Mockito.any(Task.class))).thenReturn(mockTask);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/task").accept("*").content(taskJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertNotNull(response.getStatus());

	}

	/**
	 * Sets up mock Data
	 * 
	 */
	private void mockTask() {
		ParentTask p = new ParentTask();
		p.setId(4);
		mockTask.setTaskId(1);
		mockTask.setTask("Add User");
		mockTask.setPriority(1);
		mockTask.setStartDate(new Date());
		mockTask.setProjectId(3);
		mockTask.setParentTask(p);
		mockTasks.add(mockTask);
	}
	
	/** Sets up mock Data
	 * 
	 */
	private void mockParentTask() {
		mockParentTask.setId(4);
		mockParentTask.setParentTask("Investments");
	}

}
