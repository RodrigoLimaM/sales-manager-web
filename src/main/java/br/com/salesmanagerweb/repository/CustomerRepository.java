package br.com.salesmanagerweb.repository;

import br.com.salesmanagerweb.client.CustomerClient;
import br.com.salesmanagerweb.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository implements UserDetailsService {

    @Autowired
    CustomerClient customerClient;

    @Override
    public Customer loadUserByUsername(String email) {
        return customerClient.getCustomerByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User " +email +" not found"));
    }
}
