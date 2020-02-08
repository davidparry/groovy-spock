package com.davidparry.spock;

import com.davidparry.spock.validation.Validator;

public class OddEvenCampImpl implements OddEvenCamp {

    private Validator<Integer> validator;

    public OddEvenCampImpl(Validator<Integer> validator) {
        this.validator = validator;
    }

    @Override
    public int check(int number) {
        this.validator.validate(number);
        if (number % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
