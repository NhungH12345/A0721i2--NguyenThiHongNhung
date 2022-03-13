package com.codegym.tao_dung_dung_blog.repository;

import com.codegym.tao_dung_dung_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findAll(Pageable pageable);
    @Query("select b from Blog b order by b.datecreate")
    Page<Blog> searchByTitle(String title, Pageable pageable);

}
