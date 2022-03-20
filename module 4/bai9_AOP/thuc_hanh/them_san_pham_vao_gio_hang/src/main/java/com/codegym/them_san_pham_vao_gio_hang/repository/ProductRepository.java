package com.codegym.them_san_pham_vao_gio_hang.repository;

import com.codegym.them_san_pham_vao_gio_hang.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
