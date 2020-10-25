package br.com.salesmanagerweb.controller;

import br.com.salesmanagerweb.model.CustomerRequest;
import br.com.salesmanagerweb.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
@Slf4j
public class RegisterController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ModelAndView getRegisterPage() {
        return new ModelAndView("registerForm")
                .addObject("customerRequest", new CustomerRequest());
    }

    @PostMapping
    public ModelAndView registerUser(CustomerRequest customerRequest) {
        log.info("User created: {}", customerService.createCustomer(customerRequest));
        return new ModelAndView("redirect:/login");
    }

}
