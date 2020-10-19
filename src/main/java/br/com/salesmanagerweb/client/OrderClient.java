package br.com.salesmanagerweb.client;

import br.com.salesmanagerweb.model.request.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "OrderClient", url = "${sales-manager-order.url}")
public interface OrderClient {

    @PostMapping("/order")
    OrderRequest createOrder(@RequestBody OrderRequest orderRequest);
}
