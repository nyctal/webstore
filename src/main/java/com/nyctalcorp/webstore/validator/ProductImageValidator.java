package com.nyctalcorp.webstore.validator;

import com.nyctalcorp.webstore.domain.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Giacinto on 05/05/2016.
 */
public class ProductImageValidator implements Validator {

    public long getAllowedSize() {
        return allowedSize;
    }

    public void setAllowedSize(long allowedSize) {
        this.allowedSize = allowedSize;
    }

    private long allowedSize;

    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    public void validate(Object target, Errors errors) {

        Product product = (Product) target;
        if(product.getProductImage().getSize() > allowedSize) {
            errors.rejectValue("productImage","com.nyctalcorp.webstore.validator.ProductImageValidator.message");
        }
    }
}
