package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Products> products =  new ArrayList<>();
    private Long nextId = 1L;

    public List<Products> getAllProducts(){
        return  products;
    }

    public Products addProduct(Products product){
        product.setId(nextId++);
        products.add(product);
        return product;
    }
    public Optional<Products> getProductById(Long id){
        return products.stream()
                .filter(p-> p.getId().equals(id))
                .findFirst();
    }
    public void deleteProduct(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Products> findByName(String name){
        return products.stream()
                .filter(p-> p.getName().contains(name))
                .toList();
    }
}
