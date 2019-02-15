package com.aplanTest.webApp.repository;

import com.aplanTest.webApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
