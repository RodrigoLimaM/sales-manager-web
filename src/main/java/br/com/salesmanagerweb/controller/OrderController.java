package br.com.salesmanagerweb.controller;

import br.com.salesmanagerweb.client.CountriesClient;
import br.com.salesmanagerweb.model.OrderRequest;
import br.com.salesmanagerweb.model.QuantityRequest;
import br.com.salesmanagerweb.model.TrackingRequest;
import br.com.salesmanagerweb.service.CountriesService;
import br.com.salesmanagerweb.service.OrderService;
import br.com.salesmanagerweb.service.ProductService;
import br.com.salesmanagerweb.service.TrackingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    TrackingService trackingService;

    @Autowired
    ProductService productService;

    @Autowired
    CountriesService countriesService;

    @PostMapping
    public ModelAndView createOrder(@RequestParam String _id, QuantityRequest quantityRequest) {
        return new ModelAndView("orderForm")
                .addObject("product_id", _id)
                .addObject("quantity", quantityRequest.getQuantity())
                .addObject("orderRequest", new OrderRequest())
                .addObject("countries", countriesService.getCountries());
    }

    @PostMapping("/confirmation")
    public ModelAndView requestOrder(OrderRequest orderRequest) {
        log.info("Order created: {} ", orderService.createOrder(orderRequest));
        return new ModelAndView("redirect:/order/orderConfirmation");
    }

    @GetMapping("/orderConfirmation")
    public ModelAndView getOrderConfirmation() {
        return new ModelAndView("orderConfirmation");
    }

    @GetMapping("/{_id}")
    public ModelAndView getOrderById(@PathVariable String _id) {
        OrderRequest orderRequest = orderService.getOrderById(_id);

        return new ModelAndView("orderDetails")
                .addObject("orderRequest", orderRequest)
                .addObject("tracking", trackingService.getTrackingByOrderId(_id))
                .addObject("productName", productService.getProductNameByProductId(orderRequest.getProductId()))
                .addObject("statuses", trackingService.getStatus())
                .addObject("trackingRequest", new TrackingRequest());
    }

    @GetMapping("/myOrders/{customerId}")
    public ModelAndView getOrdersByCustomerId(@PathVariable String customerId) {
        return new ModelAndView("myOrders")
                .addObject("orders", orderService.getOrdersByCustomerId(customerId));
    }

    @GetMapping("/orderManagement")
    public ModelAndView getAllOrders() {
        return new ModelAndView("allOrders")
                .addObject("orders", orderService.getAllOrders());
    }
}
