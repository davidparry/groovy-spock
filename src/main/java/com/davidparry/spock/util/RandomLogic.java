package com.davidparry.spock.util;

import java.util.Random;

public class RandomLogic {

    public String businessLogicMoneyMaker(long predictor) {
        Random random = new Random();
        
        int baseLength = Math.toIntExact(Math.abs(predictor) % 20 + 1);
        int variation = random.nextInt(5);
        int finalLength = baseLength + variation;

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        StringBuilder randomString = new StringBuilder();
        
        for (int i = 0; i < finalLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomString.append(characters.charAt(randomIndex));
        }
        
        return randomString.toString();
    }

}