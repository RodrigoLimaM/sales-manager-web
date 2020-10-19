package br.com.salesmanagerweb.controller;

import br.com.salesmanagerweb.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    ProductClient productClient;

    @RequestMapping
    public ModelAndView index() {
        return new ModelAndView("home")
                .addObject("products", productClient.getProducts());
    }
}
