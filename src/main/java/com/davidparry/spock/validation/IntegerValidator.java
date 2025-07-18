package com.davidparry.spock.validation;

import com.davidparry.spock.NegativeNumberException;

/**
 * Validator implementation for integer values.
 * <p>
 * This validator ensures that integer values meet specific criteria,
 * particularly that they are positive (greater than zero).
 * </p>
 */
public class IntegerValidator implements Validator<Integer> {

    /**
     * Validates that the given integer value is positive.
     * 
     * @param value the integer value to validate
     * @throws NegativeNumberException if the value is zero or negative
     */
    @Override
    public void validate(Integer value) {
        if (value == null) {
            throw new NegativeNumberException("Value cannot be null");
        }
        
        if (value <= 0) {
            throw new NegativeNumberException("Value must be positive, but was: " + value);
        }
    }
}