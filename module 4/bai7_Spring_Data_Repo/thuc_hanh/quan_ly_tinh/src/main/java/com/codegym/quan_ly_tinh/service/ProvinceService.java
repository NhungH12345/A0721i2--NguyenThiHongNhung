package com.codegym.quan_ly_tinh.service;

import com.codegym.quan_ly_tinh.model.Provinces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceService provinceRepository;

    public Iterable<Provinces> findAll() {
        return provinceRepository.findAll();
    }

    public Optional<Provinces> findById(Long id) {
        return provinceRepository.findById(id);
    }

    public void save(Provinces province) {
        provinceRepository.save(province);
    }

    public void remove(Long id) {
        provinceRepository.remove(id);
    }
}
