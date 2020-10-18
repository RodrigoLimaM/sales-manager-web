package br.com.salesmanagerweb.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Product {

    private String _id;

    private String name;

    private String description;

    private BigDecimal unitaryValue;
}
