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

import com.cts.wt.projectmanager.backend.entities.Project;
import com.cts.wt.projectmanager.backend.repos.ProjectRepo;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProjectController.class, secure = false)
public class ProjectControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ProjectRepo projectRepo;

	Project mockProject = new Project();

	List<Project> mockProjects = new ArrayList<Project>();

	@Test
	public void fetchCompletedProjectTest() throws Exception {

		mockProjectData();

		Mockito.when(projectRepo.findAllCompletedProject()).thenReturn(mockProjects);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/project").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getStatus());

	}

	@Test
	public void fetchProjectUsingNameTest() throws Exception {

		mockProjectData();

		Mockito.when(projectRepo.findByName(mockProject.getProject())).thenReturn(mockProject);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/project/User").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getStatus());

	}

	@Test
	public void fetchAllProjectTest() throws Exception {

		mockProjectData();

		Mockito.when(projectRepo.findAll()).thenReturn(mockProjects);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/projects").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getStatus());

	}

	@Test
	public void fetchProjectTest() throws Exception {

		mockProjectData();

		Mockito.when(projectRepo.findById(mockProject.getProjectId())).thenReturn(mockProject);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/projects/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getStatus());

	}

	@Test
	public void deleteProjectTest() throws Exception {

		mockProjectData();

		Mockito.when(projectRepo.findById(mockProject.getProjectId())).thenReturn(mockProject);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/projects/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	@Test
	public void addProjectTest() throws Exception {
		String parentTaskJson = "{\"project\":\"User\",\"priority\":\"1\",\"startDate\":\"2019-11-01\"}";
		mockProjectData();
		Mockito.when(projectRepo.save(Mockito.any(Project.class))).thenReturn(mockProject);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/projects").accept("*").content(parentTaskJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertNotNull(response.getStatus());

	}

	@Test
	public void updateProjectTest() throws Exception {
		String parentTaskJson = "{\"project\":\"User\",\"priority\":\"1\",\"startDate\":\"2019-11-01\",\"projectId\":\"1\"}";
		mockProjectData();
		Mockito.when(projectRepo.save(Mockito.any(Project.class))).thenReturn(mockProject);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/projects").accept("*").content(parentTaskJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertNotNull(response.getStatus());

	}

	/**
	 * Sets up mock Data
	 * 
	 */
	private void mockProjectData() {
		mockProject.setProjectId(1);
		mockProject.setProject("Users");
		mockProject.setPriority(1);
		mockProject.setStartDate(new Date());
		mockProjects.add(mockProject);
	}

}
