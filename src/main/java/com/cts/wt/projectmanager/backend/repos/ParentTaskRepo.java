package com.cts.wt.projectmanager.backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.wt.projectmanager.backend.entities.ParentTask;

/**
 * Repo class for Parent Task table operation.
 * 
 * @author Nilofar Sulaiman
 *
 */
public interface ParentTaskRepo extends JpaRepository<ParentTask, Integer> {
	public ParentTask findById(int id);
}
