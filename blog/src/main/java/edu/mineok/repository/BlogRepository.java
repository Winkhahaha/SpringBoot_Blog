package edu.mineok.repository;

import edu.mineok.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    @Query("select b from Blog b where b.recommend = true ")
    List<Blog> findTop(Pageable pageable);

    // 传的是方法的第一个参数
    @Query("select b from Blog b where b.title like ?1 or b.content like ?1")
    Page<Blog> findByQuery(String query, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Blog b set b.views = b.views+1 where b.id = ?1 ")
    int updateViews(Long id);

    // 查询年份,倒序排序
    @Query("select function('date_format',b.updateTime,'%Y') as year from Blog b group by function('date_format',b.updateTime,'%Y') order by year desc ")
    List<String> findGroupYears();

    // 根据年份,查询博客
    @Query("select b from Blog b where function('date_format',b.updateTime,'%Y') = ?1")
    List<Blog> findByYear(String year);
}
