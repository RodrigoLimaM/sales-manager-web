package br.com.salesmanagerweb.controller;

import br.com.salesmanagerweb.model.OrderRequest;
import br.com.salesmanagerweb.model.ProductRequest;
import br.com.salesmanagerweb.model.QuantityRequest;
import br.com.salesmanagerweb.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("product")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{_id}")
    public ModelAndView getProductById(@PathVariable String _id) {
        return new ModelAndView("product")
                .addObject("product", productService.getProductById(_id))
                .addObject("quantityRequest", new QuantityRequest());
    }

    @GetMapping("/add")
    public ModelAndView getProductForm() {
        return new ModelAndView("productForm")
                .addObject("productRequest", new ProductRequest());
    }

    @PostMapping("/confirmation")
    public ModelAndView addProduct(ProductRequest productRequest) {
        log.info("Product created: {} ", productService.addProduct(productRequest));
        return new ModelAndView("redirect:/product/productConfirmation");
    }

    @GetMapping("/productConfirmation")
    public ModelAndView getProductConfirmation() {
        return new ModelAndView("productConfirmation");
    }

}
