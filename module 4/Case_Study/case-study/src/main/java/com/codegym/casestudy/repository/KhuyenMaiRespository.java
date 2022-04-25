package com.example.thi_spring.repository;

import com.example.thi_spring.model.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface KhuyenMaiRespository extends JpaRepository<KhuyenMai,Long> {
    List<KhuyenMai> findAll();
    List<KhuyenMai> findKhuyenMaiBySale(int sale);
}
