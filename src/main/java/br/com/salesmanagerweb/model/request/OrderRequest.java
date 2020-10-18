package br.com.salesmanagerweb.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderRequest {

    private Address address;

    @Getter
    @Setter
    public static class Address {

        private String recipient;

        private String street;

        private Integer number;

        private String zipCode;

        private String city;

        private String state;

        private String country;
    }
}
