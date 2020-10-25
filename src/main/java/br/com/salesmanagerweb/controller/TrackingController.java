package br.com.salesmanagerweb.controller;

import br.com.salesmanagerweb.model.TrackingRequest;
import br.com.salesmanagerweb.service.TrackingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tracking")
@Slf4j
public class TrackingController {

    @Autowired
    TrackingService trackingService;

    @PostMapping
    public ModelAndView changeOrderStatus(String _id, TrackingRequest trackingRequest) {
        log.info("Order status changed: {} ", trackingService.addTrackingStep(_id, trackingRequest.getStep()));
        return new ModelAndView("redirect:/order/" +_id);
    }
}
