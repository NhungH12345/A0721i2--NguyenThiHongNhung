package com.codegym.casestudy.service;


import javax.xml.ws.Service;
import java.util.List;

public interface ServiceTypeService {
    List<Service> findAll();
}
