package com.codegym.tao_dung_dung_blog.repository;

import com.codegym.tao_dung_dung_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
