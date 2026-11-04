package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Products> products =  new ArrayList<>();
    private Long nextId = 1L;

    public ProductService(){
        products.add(new DigitalProduct(nextId++, "abc", 9.99, "https://download/abc", 50));
        products.add(new PhysicalProduct(nextId++, "mouse", 5.99, 1, "20x20"));
    }
    public List<Products> getAllProducts(){
        return  products;
    }

    public Optional<Products> getProductById(Long id){
        return products.stream()
                .filter(p-> p.getId().equals(id))
                .findFirst();
    }
    public Products addProduct(Products product){
        product.setId(nextId++);
        products.add(product);
        return product;
    }
    public void deleteProduct(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<String> getAllSummaries(){
        List<String> summaries = new ArrayList<>();
        for(Products p: products){
            summaries.add(p.getSummary());
        }
        return summaries;

    }

//    public List<Products> findByName(String name){
//        return products.stream()
//                .filter(p-> p.getName().contains(name))
//                .toList();
//    }
}
