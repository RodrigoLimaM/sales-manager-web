package br.com.salesmanagerweb.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {

    private String _id;

    private String name;

    private String description;

    private Integer quantity;

    private BigDecimal unitaryValue;
}
