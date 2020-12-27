package br.com.salesmanagerweb.service;

import br.com.salesmanagerweb.client.ProductClient;
import br.com.salesmanagerweb.model.Product;
import br.com.salesmanagerweb.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductClient productClient;


    public String getProductNameByProductId(String productId) {
        return productClient.getProductById(productId).getName();
    }

    public Product getProductById(String _id) {
        return productClient.getProductById(_id);
    }

    public List<Product> getProducts() {
        return productClient.getProducts();
    }

    public ProductRequest addProduct(ProductRequest productRequest) {
        return productClient.addProduct(productRequest);
    }
}
