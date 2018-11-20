package com.cts.wt.projectmanager.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity Class for Parent Task Table.
 * 
 * @author Nilofar Sulaiman
 *
 */
@Entity(name = "parent_task")
public class ParentTask {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column
	String parentTask;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the parentTask
	 */
	public String getParentTask() {
		return parentTask;
	}

	/**
	 * @param parentTask
	 *            the parentTask to set
	 */
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

}
