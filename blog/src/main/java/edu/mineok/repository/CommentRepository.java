package edu.mineok.repository;

import edu.mineok.entity.Blog;
import edu.mineok.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 根据创建时间倒序排,判断其父评论是否空
    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}
