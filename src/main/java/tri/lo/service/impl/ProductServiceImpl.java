package tri.lo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tri.lo.model.Product;
import tri.lo.repository.ProductRepository;
import tri.lo.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(long id) {
        productRepository.remove(id);
    }
}
