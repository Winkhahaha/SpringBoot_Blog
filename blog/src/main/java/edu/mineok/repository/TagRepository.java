package edu.mineok.repository;

import edu.mineok.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);
}
