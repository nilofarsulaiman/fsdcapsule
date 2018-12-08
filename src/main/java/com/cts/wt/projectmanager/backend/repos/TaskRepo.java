package com.cts.wt.projectmanager.backend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.wt.projectmanager.backend.entities.Project;
import com.cts.wt.projectmanager.backend.entities.Task;

/**
 * Repo class for Task table.
 * 
 * @author Nilofar Sulaiman
 *
 */
public interface TaskRepo extends JpaRepository<Task, Integer> {

	public Task findById(int taskId);

	@Query("select t from task t where t.endDate < current_date")
	public List<Task> findAllCompletedProject();
	
	@Query("Select t from task t where t.projectId = :projectId")
	public  List<Task> findTaskByProject(@Param("projectId") int projectId);

}
