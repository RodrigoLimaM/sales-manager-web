package br.com.salesmanagerweb.client;

import br.com.salesmanagerweb.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ProductClient", url = "${sales-manager-product.url}")
public interface ProductClient {

    @GetMapping("/product")
    List<Product> getProductById();

    @GetMapping("/product/{_id}")
    Product getProductById(@PathVariable String _id);
}