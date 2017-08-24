package com.madstuff.controller;


import com.madstuff.Service.ProductService;
import com.madstuff.entities.Category;
import com.madstuff.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.madstuff.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/MadStuff")
public class MadStuffController {

    @Autowired
    private ProductService productService;

    public MadStuffController(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping(path = "add" , method = RequestMethod.POST)
    public @ResponseBody String addProduct(@RequestBody List<Product> productList){

        if(null == productList || productList.isEmpty())
            return "Please add some products";

        List<Product> products = new ArrayList<>();
        for (Product pro: productList) {
            products.add(new Product(pro));
        }

        productService.save(products);

        return "product added successfully!";
    }

    @RequestMapping(path = "all" , method = RequestMethod.GET)
    public @ResponseBody Iterable<Product> getAll(){

        return productService.findAll();
    }

    @RequestMapping(path = "brand/{brandName}")
    public @ResponseBody Iterable<Product> getByBrand(@PathVariable String brandName){
        return productService.findByBrand(brandName);
    }

    @RequestMapping(path = "priceBetween")
    public @ResponseBody Iterable<Product> getByBrand(@RequestParam Double minPrice, @RequestParam Double maxPrice){
        return productService.findByCostBetween(minPrice,maxPrice);
    }

    public @ResponseBody String updateProductDetail(){

        return "product updated successfully!";
    }



}
