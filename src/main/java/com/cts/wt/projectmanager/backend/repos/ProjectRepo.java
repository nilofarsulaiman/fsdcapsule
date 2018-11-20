package com.cts.wt.projectmanager.backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.wt.projectmanager.backend.entities.Project;

/**
 * Repo class for Parent Task table operation.
 * 
 * @author Nilofar Sulaiman
 *
 */
public interface ProjectRepo extends JpaRepository<Project, Integer> {
	public Project findById(int id);
}
