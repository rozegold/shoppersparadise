package com.madstuff.Service;

import com.madstuff.entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface ProductService {

    void save(List<Product> products);

    Iterable<Product> findAll();

    Iterable<Product> findByBrand(String brandName);

    Iterable<Product> findByCostBetween(Double minPrice, Double maxPrice);
}
