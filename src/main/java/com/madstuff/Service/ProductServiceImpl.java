package com.madstuff.Service;

import com.madstuff.entities.Product;
import com.madstuff.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements  ProductService{

    @Autowired
    private ProductRepository repository;


    @Override
    public void save(List<Product> products) {
        repository.save(products);
    }

    @Override
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Product> findByBrand(String brand) {
        return repository.findProductByBrand(brand);
    }

    @Override
    public Iterable<Product> findByCostBetween(Double minPrice, Double maxPrice) {
        return repository.findProductByCostBetween(minPrice, maxPrice);
    }
}
