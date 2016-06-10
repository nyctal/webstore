package com.nyctalcorp.webstore.validator;

/**
 * Created by Giacinto on 05/05/2016.
 */
import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.nyctalcorp.webstore.domain.Product;
@Component
public class UnitsInStockValidator implements Validator{
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        if(product.getUnitPrice()!= null && new BigDecimal(10000).compareTo(product.getUnitPrice())<=0 && product.getUnitsInStock()>99) {
            errors.rejectValue("unitsInStock","com.nyctalcorp.webstore.validator.UnitsInStockValidator.message");
        }
    }
}
