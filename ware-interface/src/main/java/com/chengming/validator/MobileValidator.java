package com.chengming.validator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class MobileValidator implements ConstraintValidator<Mobile, CharSequence> {

    private  boolean required = false;

    private final Pattern pattern = Pattern.compile("^1[34578][0-9]{9}$");
    @Override
    public void initialize(Mobile constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        if (this.required || StringUtils.hasText(charSequence)){
            return isMobile(charSequence);
        }
        return true;
    }


    private boolean isMobile(final CharSequence str) {
        return pattern.matcher(str).matches();
    }
}
