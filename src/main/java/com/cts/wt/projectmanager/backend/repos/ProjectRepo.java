package com.cts.wt.projectmanager.backend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.wt.projectmanager.backend.entities.Project;

/**
 * Repo class for Parent Task table operation.
 * 
 * @author Nilofar Sulaiman
 *
 */
public interface ProjectRepo extends JpaRepository<Project, Integer> {
	public Project findById(int id);

	@Query("Select p from project p where LOWER(p.project) = LOWER(:project)")
	public Project findByName(@Param("project") String project);
	
	@Query("select p from project p where p.endDate < current_date")
	public List<Project> findAllCompletedProject();
}
