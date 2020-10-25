package br.com.salesmanagerweb.client;

import br.com.salesmanagerweb.model.Customer;
import br.com.salesmanagerweb.model.CustomerRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(name = "CustomerClient", url = "${sales-manager-customer.url}")
public interface CustomerClient {

    @GetMapping("/customer/{email}")
    Optional<Customer> getCustomerByEmail(@PathVariable String email);

    @GetMapping("/customer")
    Customer createCustomer(@RequestBody CustomerRequest customerRequest);
}
