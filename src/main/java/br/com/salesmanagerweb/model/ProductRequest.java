package br.com.salesmanagerweb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class ProductRequest {

    private String name;

    private Integer quantity;

    private BigDecimal unitaryValue;

    private String description;
}
