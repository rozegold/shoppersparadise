package com.madstuff.repository;

import com.madstuff.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {


        Iterable<Product> findProductByBrand(String brand);

        Iterable<Product> findProductByCostBetween(Double min , Double max);
}

