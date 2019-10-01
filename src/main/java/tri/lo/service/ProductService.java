package tri.lo.service;

import tri.lo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(long id);

    void save(Product product);

    void remove(long id);
}
