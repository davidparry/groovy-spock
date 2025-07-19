package com.davidparry.spock;

import com.davidparry.spock.util.RandomLogic;

public class ProviderOfCrazyWords {

    private RandomLogic randomLogic = new RandomLogic();

    public String giveMeACrazyNonce() {
        return randomLogic.businessLogicMoneyMaker(System.currentTimeMillis());
    }

}
