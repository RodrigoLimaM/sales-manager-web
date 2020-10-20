package br.com.salesmanagerweb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderRequest {

    private String customerId;

    private String productId;

    private Address address;

    private Integer productQuantity;

    @Getter
    @Setter
    @ToString
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
