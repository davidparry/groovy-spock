package com.davidparry.spock;

import com.davidparry.spock.validation.NegativeChecker;
import com.davidparry.spock.validation.Validator;

public class OddEvenDecider implements OddEvenCamp {
    Validator<Integer> validator = new NegativeChecker();

    public OddEvenDecider(Validator<Integer> validator) {
        this.validator = validator;
    }

    public int useMe(String value) {
       int v =  checkmeout(value);
       return  somemorework(v);
    }

    private int somemorework(int value) {
        return ++value;
    }

    private int checkmeout(String value) {
        return Integer.parseInt(value);
    }


    @Override
    public int check(int number) {
        validator.validate(number);
        if(number % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
