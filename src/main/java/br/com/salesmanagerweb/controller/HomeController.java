package br.com.salesmanagerweb.controller;

import br.com.salesmanagerweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @RequestMapping
    public ModelAndView index() {
        return new ModelAndView("home")
                .addObject("products", productService.getProducts());
    }
}
