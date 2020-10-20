package br.com.salesmanagerweb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class Step {

    private OrderStatus orderStatus;

    private LocalDateTime date;

    private String description;

    private Boolean finisher;
}
