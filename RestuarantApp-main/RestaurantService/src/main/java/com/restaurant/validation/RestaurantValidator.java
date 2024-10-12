package com.restaurant.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import org.springframework.validation.beanvalidation.CustomValidatorBean;

import com.restaurant.model.BookTable;


@Component
public class RestaurantValidator extends CustomValidatorBean{
	
    @Override
    public boolean supports(Class<?> clazz) {
    return BookTable.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
          super.validate(target, errors);
    }
      

    }



