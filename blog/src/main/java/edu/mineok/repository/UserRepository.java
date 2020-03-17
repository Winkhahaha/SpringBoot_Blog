package edu.mineok.repository;

import edu.mineok.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndAndPassword(String username, String password);
}
