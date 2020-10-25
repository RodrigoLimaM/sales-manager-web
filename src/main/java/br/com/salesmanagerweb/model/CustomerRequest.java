package br.com.salesmanagerweb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class CustomerRequest {

    private String name;

    private String email;

    private String password;

    private BigDecimal balance;
}
