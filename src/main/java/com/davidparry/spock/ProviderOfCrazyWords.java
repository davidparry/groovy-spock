package com.davidparry.spock;

import com.davidparry.spock.util.RandomLogic;

public class ProviderOfCrazyWords {

    private final RandomLogic randomLogic;

    public ProviderOfCrazyWords(RandomLogic randomLogic) {
        this.randomLogic = randomLogic;
    }

    public String giveMeACrazyNonce(long value) {
        if(value > 0) {
            return randomLogic.businessLogicMoneyMaker(value);
        } else {
            return randomLogic.businessLogicMoneyMaker(System.currentTimeMillis());
        }
    }

}
