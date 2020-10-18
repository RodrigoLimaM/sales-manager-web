package br.com.salesmanagerweb.service;

import br.com.salesmanagerweb.client.ProductClient;
import br.com.salesmanagerweb.model.response.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductClient productClient;

    public List<Product> getProducts() {
        return productClient.getProductById();
    }

    public Product findById(String id) {
        return productClient.getProductById(id);
    }
}
