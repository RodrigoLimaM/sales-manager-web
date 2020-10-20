package br.com.salesmanagerweb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class OrderTracking {

    private List<Step> steps;

}
