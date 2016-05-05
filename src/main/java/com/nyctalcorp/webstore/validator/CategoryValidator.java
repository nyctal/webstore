package com.nyctalcorp.webstore.validator;

/**
 * Created by Giacinto on 04/05/2016.
 */
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.EnumMap;

public class CategoryValidator implements ConstraintValidator<Category, String>{

    private AllowedCategories allowedCategories;

    public void initialize(Category category) {
        // intentionally left blank; this is the place to initialize the constraint annotation for any sensible default values.
        this.allowedCategories = category.value();
    }
    public boolean isValid(String value, ConstraintValidatorContext context) {
        EnumMap<AllowedCategories, String> map =  new EnumMap<AllowedCategories, String>(AllowedCategories.class);
        return map.containsValue(value);
    }

}
