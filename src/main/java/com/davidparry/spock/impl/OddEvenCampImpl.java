package com.davidparry.spock.impl;

import com.davidparry.spock.NegativeNumberException;
import com.davidparry.spock.OddEvenCamp;
import com.davidparry.spock.validation.IntegerValidator;
import com.davidparry.spock.validation.Validator;

/**
 * Implementation of the OddEvenCamp interface that determines if numbers are odd or even.
 * <p>
 * This class provides functionality to check if a given positive integer is odd or even,
 * returning 1 for even numbers and 0 for odd numbers. It validates input to ensure
 * only positive numbers are processed.
 * </p>
 */
public class OddEvenCampImpl implements OddEvenCamp {

    private final Validator<Integer> validator;

    /**
     * Constructs a new OddEvenCampImpl with a default integer validator.
     */
    public OddEvenCampImpl() {
        this.validator = new IntegerValidator();
    }

    /**
     * Constructs a new OddEvenCampImpl with the specified validator.
     * 
     * @param validator the validator to use for input validation
     */
    public OddEvenCampImpl(Validator<Integer> validator) {
        this.validator = validator;
    }

    /**
     * Checks if the given number is even or odd.
     * 
     * @param number the number to be checked (must be positive)
     * @return 1 for even numbers, 0 for odd numbers
     * @throws NegativeNumberException if the number is 0 or negative
     */
    @Override
    public int check(int number) {
        // Validate the input using the validator
        validator.validate(number);
        
        // Check if the number is even or odd
        // Even numbers are divisible by 2 (remainder is 0)
        // Return 1 for even, 0 for odd
        return (number % 2 == 0) ? 1 : 0;
    }
}