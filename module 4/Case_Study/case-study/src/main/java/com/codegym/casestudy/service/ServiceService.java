package com.codegym.casestudy.service;


import com.codegym.casestudy.model.Service;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();
    void saveService(com.codegym.casestudy.model.Service service);//pt thêm mơi và update(tự hieu gióng id la update)
    void deleteService(Long id);
    com.codegym.casestudy.model.Service findServiceById(Long id);

}


