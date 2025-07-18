package com.davidparry.spock.validation;

import com.davidparry.spock.NegativeNumberException;

public interface Validator<T> {

    /**
     * Create a method that checks if the integer value is an even or odd number, return 1 for even and 0 for odd.
     * If number is 0 or negative number throw a runtime exception
     *
     * @param value the number to be checked
     * @return 1 for even 0 for odd
     * @throws NegativeNumberException
     */
    void validate(T value);

}
