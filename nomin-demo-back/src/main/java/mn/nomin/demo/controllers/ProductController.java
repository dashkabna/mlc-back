package mn.nomin.demo.controllers;

import mn.nomin.demo.entities.Employee;
import mn.nomin.demo.entities.Product;
import mn.nomin.demo.services.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAll() {

        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{pKey}")
    public ResponseEntity<Product> get(@PathVariable("pKey") Long pKey) {
        Product res = service.get(pKey);
        return ResponseEntity.ok(res);
    }

    @PostMapping()
    public ResponseEntity<Product> save(@RequestBody Product req) {
        Product res = service.save(req);
        return ResponseEntity.ok(res);
    }

    @PutMapping()
    public ResponseEntity<Product> update(@RequestBody Product req) {
        service.update(req);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{pKey}")
    public ResponseEntity<?> delete(@PathVariable("pKey") Long pKey) {
        service.delete(pKey);
        return ResponseEntity.ok().build();
    }
}
