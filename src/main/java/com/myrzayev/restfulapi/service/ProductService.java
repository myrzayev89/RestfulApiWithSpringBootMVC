package com.myrzayev.restfulapi.service;

import com.myrzayev.restfulapi.entity.Product;
import com.myrzayev.restfulapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository prodRepo;

    public List<Product> listAll(String q) {
        if (q != null) {
            return prodRepo.search(q);
        }
        return prodRepo.findAll();
    }

    public List<Product> getAllProd() {
        return prodRepo.findAll();
    }

    public Product getById(int id) {
        return prodRepo.findById(id).get();
    }

    public void save(Product p) {
        prodRepo.save(p);
    }

    public void delete(int id) {
        prodRepo.deleteById(id);
    }
}
