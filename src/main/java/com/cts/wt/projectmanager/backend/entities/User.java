package com.cts.wt.projectmanager.backend.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity Class for Task table.
 * 
 * @author Nilofar Sulaiman
 *
 */
@Entity(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int userId;

	@Column
	String firstName;
	
	@Column
	String lastName;
	
	@Column
	String employeeId;

	
	@ManyToOne(cascade = CascadeType.ALL)
	Project project;
	

	@ManyToOne(cascade = CascadeType.ALL)
	Task task;


	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}


	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}


	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}


	/**
	 * @return the task
	 */
	public Task getTask() {
		return task;
	}


	/**
	 * @param task the task to set
	 */
	public void setTask(Task task) {
		this.task = task;
	}

	

}
