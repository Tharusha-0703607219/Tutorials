package uk.ac.westminster.productsapi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping({"/products"})
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping({"/products/{id}"})
    public Product getProductById(@PathVariable Long id) {
        return (Product)this.productService.getProductById(id).orElse((Product) null);
    }

    @PostMapping({"/products"})
    public Product addProduct(@RequestBody Product product) {
        return this.productService.addProduct(product);
    }

    @DeleteMapping({"/products/{id}"})
    public void deleteProduct(@PathVariable Long id) {
        this.productService.deleteProduct(id);
    }

    @GetMapping({"/products/search"})
    public List<Product> search(@RequestParam String name) {
        return this.productService.findByName(name);
    }

    @GetMapping("/products/summaries")
    public List<String> getSummaries() {
        return productService.getAllSummaries();
    }
}