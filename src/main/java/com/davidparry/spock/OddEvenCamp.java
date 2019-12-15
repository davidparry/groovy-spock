package com.davidparry.spock;

import com.davidparry.spock.validation.Validator;

public class OddEvenCamp {

    private Validator<Integer> validator;

    public OddEvenCamp(Validator<Integer> validator) {
        this.validator = validator;
    }

    /**
     * Check if value is an even or odd number. if number is a 0 or negative number throw a runtime exception
     * @param number the number to be checked
     * @return 1 for even 0 for odd
     */
    int check(int number) {
        this.validator.validate(number);
        if (number % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

}
