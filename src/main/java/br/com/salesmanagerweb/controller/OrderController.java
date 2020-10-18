package br.com.salesmanagerweb.controller;

import br.com.salesmanagerweb.model.dto.QuantityDTO;
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

    @PostMapping
    public ModelAndView createOrder(@RequestParam String _id, QuantityDTO quantityDTO) {
        return new ModelAndView("order")
                .addObject("product_id", _id)
                .addObject("quantity", quantityDTO.getQuantity());
    }
}
