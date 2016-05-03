package com.nyctalcorp.webstore.exception;

/**
 * Created by Giacinto on 26/04/2016.
 */
public class ProductNotFoundException extends RuntimeException{
    private static final long serialVersionUID =-694354952032299587L;
    private String productId;
    public ProductNotFoundException(String productId) {
        this.productId = productId;
    }
    public String getProductId() {
        return productId;
    }
}
