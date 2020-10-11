package com.myrzayev.restfulapi.repository;

import com.myrzayev.restfulapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where concat(p.prodName, ' ') like %?1%")
    public List<Product> search(String q);
}
