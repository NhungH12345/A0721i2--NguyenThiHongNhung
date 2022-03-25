package com.codegym.quan_ly_tinh.repository;

import com.codegym.quan_ly_tinh.model.Provinces;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceReposytory extends PagingAndSortingRepository<Provinces, Long> {
}
