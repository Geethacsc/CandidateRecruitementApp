package com.capstone.CandidateRecruit.repo;

import com.capstone.CandidateRecruit.dto.CandidateDTO;
import com.capstone.CandidateRecruit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Long> {

    User findByUserIdAndPassword(String userId,String password);
}
