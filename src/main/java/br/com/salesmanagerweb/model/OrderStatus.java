package br.com.salesmanagerweb.model;

public enum OrderStatus {

    PROCESSING_PAYMENT,
    APPROVED,
    CANCELLED,
    PREPARING_FOR_SHIPPING,
    IN_SEPARATION,
    SENT_TO_CARRIER,
    OUT_FOR_SHIPMENT,
    DELIVERED,
    MISSING_RECIPIENT,
    MISPLACED,
    ;
}
