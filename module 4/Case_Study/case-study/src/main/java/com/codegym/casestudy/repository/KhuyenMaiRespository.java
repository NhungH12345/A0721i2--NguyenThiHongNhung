package com.codegym.casestudy.repository;
import com.codegym.casestudy.model.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface KhuyenMaiRespository extends JpaRepository<KhuyenMai,Long> {
    List<KhuyenMai> findAll();
    List<KhuyenMai> findKhuyenMaiBySale(int sale);

    void saveKhuyenMai(KhuyenMai khuyenMai);
}
