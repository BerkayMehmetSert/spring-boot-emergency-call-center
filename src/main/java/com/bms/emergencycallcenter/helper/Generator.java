package com.bms.emergencycallcenter.helper;

import com.bms.emergencycallcenter.helper.message.BusinessMessage;

import java.util.Random;

public class Generator {
    private Generator() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final Random RANDOM = new Random();
    public static final StringBuilder CODE = new StringBuilder();

    public static String generateCode() {

        for (int i = 0; i < 2; i++) {
            CODE.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        CODE.append("-");

        for (int i = 0; i < 4; i++) {
            CODE.append(NUMBERS.charAt(RANDOM.nextInt(NUMBERS.length())));
        }

        CODE.append("-");

        for (int i = 0; i < 2; i++) {
            CODE.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return CODE.toString();
    }
}
