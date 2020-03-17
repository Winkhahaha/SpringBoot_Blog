package edu.mineok.repository;

import edu.mineok.entity.Type;
import edu.mineok.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);
}
