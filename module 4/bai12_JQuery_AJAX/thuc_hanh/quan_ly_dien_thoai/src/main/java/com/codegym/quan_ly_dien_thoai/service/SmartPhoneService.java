package com.codegym.quan_ly_dien_thoai.service;

import com.codegym.quan_ly_dien_thoai.model.SmartPhone;
import com.codegym.quan_ly_dien_thoai.repository.SmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartPhoneService {
    @Autowired
    private SmartPhoneRepository smartPhoneRepository;

    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }
}
