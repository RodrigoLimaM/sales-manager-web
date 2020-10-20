package br.com.salesmanagerweb.client;

import br.com.salesmanagerweb.model.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "OrderClient", url = "${sales-manager-order.url}")
public interface OrderClient {

    @PostMapping("/order")
    OrderRequest createOrder(@RequestBody OrderRequest orderRequest);

    @GetMapping("/order/{_id}")
    OrderRequest getOrderById(@PathVariable String _id);

    @GetMapping("/order/customer/{customerId}")
    List<OrderRequest> getOrderByCustomerId(@PathVariable String customerId);
}
