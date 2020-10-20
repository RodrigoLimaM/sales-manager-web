package br.com.salesmanagerweb.controller;

import br.com.salesmanagerweb.client.OrderClient;
import br.com.salesmanagerweb.model.request.OrderRequest;
import br.com.salesmanagerweb.model.request.QuantityRequest;
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
public class OrderController {

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
        return new ModelAndView("redirect:/order/orderConfirmation");
    }

    @GetMapping("/orderConfirmation")
    public ModelAndView getOrderConfirmation() {
        return new ModelAndView("orderConfirmation");
    }

    @GetMapping("/{_id}")
    public ModelAndView getProductById(@PathVariable String _id) {
        return new ModelAndView("orderDetails")
                .addObject("orderRequest", orderClient.getOrderById(_id));
    }
}
