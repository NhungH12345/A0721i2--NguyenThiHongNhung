package com.codegym.casestudy.service.Impl;

import com.codegym.casestudy.model.KhuyenMai;
import com.codegym.casestudy.repository.KhuyenMaiRespository;
import com.codegym.casestudy.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {
    @Autowired
    private KhuyenMaiRespository khuyenMaiRespository;

    @Override
    public void saveKhuyenMai(KhuyenMai khuyenMai) {
        khuyenMaiRespository.save(khuyenMai);
    }

    @Override
    public void deleteKhuyenMai(Long id) {
    khuyenMaiRespository.deleteById(id);
    }

    @Override
    public Optional<KhuyenMai> findKhuyenMaiById(Long id) {
        return khuyenMaiRespository.findById(id);
    }

    @Override
    public List<KhuyenMai> findAll() {
        return khuyenMaiRespository.findAll();
    }

    @Override
    public List<KhuyenMai> findKhuyenMaiBySale(int sale) {
        return khuyenMaiRespository.findKhuyenMaiBySale(sale);
    }


}
