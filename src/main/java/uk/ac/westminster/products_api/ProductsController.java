package uk.ac.westminster.products_api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
public class ProductsController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Products getProductsById(@PathVariable Long id){
        return productService.getProductById(id).orElse(null);
    }

    @PostMapping("/products")
    public Products addProducts(@RequestBody Products products){
        return productService.addProduct(products);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
    @GetMapping("/products/search")
    public List<Products> searchProducts(@RequestParam String name){
        return productService.findByName(name);
    }

}
