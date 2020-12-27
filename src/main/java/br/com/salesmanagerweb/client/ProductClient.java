package br.com.salesmanagerweb.client;

import br.com.salesmanagerweb.model.Product;
import br.com.salesmanagerweb.model.ProductRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ProductClient", url = "${sales-manager-product.url}")
public interface ProductClient {

    @GetMapping("/product")
    List<Product> getProducts();

    @GetMapping("/product/{_id}")
    Product getProductById(@PathVariable String _id);

    @PostMapping("/product")
    ProductRequest addProduct(@RequestBody ProductRequest productRequest);
}
