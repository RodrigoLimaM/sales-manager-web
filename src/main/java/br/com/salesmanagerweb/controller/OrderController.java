package br.com.salesmanagerweb.controller;

import br.com.salesmanagerweb.client.OrderClient;
import br.com.salesmanagerweb.model.request.OrderRequest;
import br.com.salesmanagerweb.model.request.QuantityRequest;
import br.com.salesmanagerweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    ProductService productService;

    @Autowired
    OrderClient orderClient;

    @PostMapping
    public ModelAndView createOrder(@RequestParam String _id, QuantityRequest quantityRequest) {
        return new ModelAndView("orderForm")
                .addObject("product_id", _id)
                .addObject("quantity", quantityRequest.getQuantity())
                .addObject("orderRequest", new OrderRequest());
    }

    @PostMapping("/confirmation")
    public ModelAndView requestOrder(OrderRequest orderRequest) {
        System.out.println(orderRequest);
        return new ModelAndView("orderConfirmation")
                .addObject("orderRequest", orderClient.createOrder(orderRequest));
    }
}
