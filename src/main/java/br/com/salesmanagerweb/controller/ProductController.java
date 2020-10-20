package br.com.salesmanagerweb.controller;

import br.com.salesmanagerweb.client.ProductClient;
import br.com.salesmanagerweb.model.QuantityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductClient productClient;

    @GetMapping("/{_id}")
    public ModelAndView getProductById(@PathVariable String _id) {
        return new ModelAndView("product")
                .addObject("product", productClient.getProductById(_id))
                .addObject("quantityRequest", new QuantityRequest());
    }
}
