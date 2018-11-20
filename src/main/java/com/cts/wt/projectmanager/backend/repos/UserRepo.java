package com.cts.wt.projectmanager.backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.wt.projectmanager.backend.entities.User;

/**
 * Repo class for Task table.
 * 
 * @author Nilofar Sulaiman
 *
 */
public interface UserRepo extends JpaRepository<User, Integer> {

	public User findById(int taskId);

}
