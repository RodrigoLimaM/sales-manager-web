package br.com.salesmanagerweb.client;

import br.com.salesmanagerweb.model.OrderRequest;
import br.com.salesmanagerweb.model.OrderTracking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "TrackingClient", url = "${sales-manager-tracking.url}")
public interface TrackingClient {

    @GetMapping("/tracking/{orderId}")
    OrderTracking getTrackingByOrderId(@PathVariable String orderId);
}
