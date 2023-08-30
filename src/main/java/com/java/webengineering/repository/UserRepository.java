package com.java.webengineering.repository;

import com.java.webengineering.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Methods getAll and add already exist

    User findByEmail(String email);

}
