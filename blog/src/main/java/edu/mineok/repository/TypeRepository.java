package edu.mineok.repository;

import edu.mineok.entity.Type;
import edu.mineok.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);

    // 根据分页的大小限制查询条数
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
