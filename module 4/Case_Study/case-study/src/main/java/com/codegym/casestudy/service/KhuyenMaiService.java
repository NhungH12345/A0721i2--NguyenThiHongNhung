package com.codegym.casestudy.service;

import com.codegym.casestudy.model.KhuyenMai;

import java.util.List;
import java.util.Optional;

public interface KhuyenMaiService {
    void saveKhuyenMai(KhuyenMai khuyenMai);
    void deleteKhuyenMai(Long id);
    Optional<KhuyenMai> findKhuyenMaiById(Long id);
    List<KhuyenMai> findAll();
    List<KhuyenMai> findKhuyenMaiBySale(int sale);
}
