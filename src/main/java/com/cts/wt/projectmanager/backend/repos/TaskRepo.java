package com.cts.wt.projectmanager.backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.wt.projectmanager.backend.entities.Task;

/**
 * Repo class for Task table.
 * 
 * @author Nilofar Sulaiman
 *
 */
public interface TaskRepo extends JpaRepository<Task, Integer> {

	public Task findById(int taskId);

}
