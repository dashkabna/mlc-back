package mn.nomin.demo.services;

import mn.nomin.demo.core.BaseServiceImpl;
import mn.nomin.demo.entities.Product;
import mn.nomin.demo.repositories.ProductRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public JpaRepository<Product, Long> getRepo() {
        return productRepository;
    }
}
