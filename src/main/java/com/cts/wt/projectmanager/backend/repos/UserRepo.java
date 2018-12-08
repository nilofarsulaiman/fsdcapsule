package com.cts.wt.projectmanager.backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.wt.projectmanager.backend.entities.User;

/**
 * Repo class for Task table.
 * 
 * @author Nilofar Sulaiman
 *
 */
public interface UserRepo extends JpaRepository<User, Integer> {

	public User findById(int taskId);
	
	@Query("Select u from users u where LOWER(u.firstName) = LOWER(:name)")
	public User findIdByName(@Param("name") String name);

}
