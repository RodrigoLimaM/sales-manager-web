package br.com.salesmanagerweb.service;

import br.com.salesmanagerweb.client.CustomerClient;
import br.com.salesmanagerweb.model.Customer;
import br.com.salesmanagerweb.model.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerClient customerClient;

    public Customer createCustomer(CustomerRequest customerRequest) {
        return customerClient.createCustomer(customerRequest);
    }
}
