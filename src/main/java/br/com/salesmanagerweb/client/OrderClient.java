package br.com.salesmanagerweb.client;

import br.com.salesmanagerweb.model.request.OrderRequest;
import br.com.salesmanagerweb.model.response.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "OrderClient", url = "${sales-manager-order.url}")
public interface OrderClient {

    @PostMapping("/order")
    OrderRequest createOrder(@RequestBody OrderRequest orderRequest);

    @GetMapping("/order/{_id}")
    OrderRequest getOrderById(@PathVariable String _id);
}
