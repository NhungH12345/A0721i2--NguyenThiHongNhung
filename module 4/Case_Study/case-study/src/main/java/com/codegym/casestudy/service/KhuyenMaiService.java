package com.example.thi_spring.service;

import com.example.thi_spring.model.KhuyenMai;

import java.util.List;
import java.util.Optional;

public interface KhuyenMaiService {
    void saveKhuyenMai(KhuyenMai khuyenMai);
    void deleteKhuyenMai(Long id);
    Optional<KhuyenMai> findKhuyenMaiById(Long id);
    List<KhuyenMai> findAll();
    List<KhuyenMai> findKhuyenMaiBySale(int sale);
}
