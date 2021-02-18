package com.timberliu.springboot.validation.core.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: Timber
 * @date: 2021/2/7
 */
public class InEnumValidator implements ConstraintValidator<InEnum, Integer> {

    private Set<Integer> values;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (values.contains(value)) {
            return true;
        }
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(constraintValidatorContext.getDefaultConstraintMessageTemplate()
                .replaceAll("\\{value}", value.toString())).addConstraintViolation();
        return false;
    }

    @Override
    public void initialize(InEnum constraintAnnotation) {
        IntArrayValuable[] values = constraintAnnotation.value().getEnumConstants();
        if (values.length == 0) {
            this.values = Collections.emptySet();
        } else {
            this.values = Arrays.stream(values[0].array()).boxed().collect(Collectors.toSet());
        }
    }
}
