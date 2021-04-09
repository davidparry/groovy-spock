package com.davidparry.spock;

import com.davidparry.spock.validation.Validator;

public class OddEvenCampImpl implements OddEvenCamp {

    private final Validator<Integer> validator;

    public OddEvenCampImpl(Validator<Integer> validator) {
        this.validator = validator;
    }


    @Override
    public int check(int number) {
        if(number == 200) {
            number = 3;
        }
        this.validator.validate(number);
        if (number % 2 == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
