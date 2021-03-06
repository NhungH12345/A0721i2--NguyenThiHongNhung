package com.shop.service.Impl;
import com.shop.model.Product;
import com.shop.repository.ProductRepository;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);

    }

    @Override
    public Optional<Product> findProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<Product> findProductByNameContaining(String name, Pageable pageable) {
        return productRepository.findAllByNameContaining(name,pageable);
    }
    @Override
    public void addFile(Product productsEnity, MultipartFile productAvatar
    ) throws IllegalStateException, IOException {

        String pathToFile ="F:\\A0721i2--NguyenThiHongNhung\\do_an\\src\\main\\resources\\static\\images\\avatar\\"
                + productAvatar.getOriginalFilename();
        // tạo file
        File file = new File(pathToFile);
        //chuyển data vào cái file vừa tạo
        productAvatar.transferTo(new File(pathToFile));
        //luu tên ảnh vào db
        productsEnity.setAvatar(productAvatar.getOriginalFilename());
        saveProduct(productsEnity);

    }

    @Override
    public void editFile(Product productsEnity, MultipartFile productAvatar) throws IOException {

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
        /*
        check xem có ảnh đó có muốn thay đổi hay không
        nếu có tìm cái ảnh cũ xóa nó đi : File(pathToFile).delete()
        thêm ảnh mới giống method addFile
         */






}
