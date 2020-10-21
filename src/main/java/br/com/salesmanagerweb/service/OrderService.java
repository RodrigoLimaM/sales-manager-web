package br.com.salesmanagerweb.service;

import br.com.salesmanagerweb.client.OrderClient;
import br.com.salesmanagerweb.client.ProductClient;
import br.com.salesmanagerweb.model.OrderRequest;
import br.com.salesmanagerweb.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    ProductClient productClient;

    @Autowired
    OrderClient orderClient;


    public List<OrderRequest> getOrdersByCustomerId(String customerId) {
        List<OrderRequest> orders = orderClient.getOrdersByCustomerId(customerId);

        orders.stream()
                .forEach(
                        order -> order.setProductName(productClient.getProductById(order.getProductId()).getName())
                );

        return orders;
    }

    public OrderRequest getOrderById(String _id) {
        return orderClient.getOrderById(_id);
    }

    public OrderRequest createOrder(OrderRequest orderRequest) {
        return orderClient.createOrder(orderRequest);
    }

}
