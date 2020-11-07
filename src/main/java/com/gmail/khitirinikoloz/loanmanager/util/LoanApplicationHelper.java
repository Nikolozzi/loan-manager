package com.gmail.khitirinikoloz.loanmanager.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanApplicationHelper {

    public static Map<Character, Integer> getAlphabet() {
        final List<Character> alphabet = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

        final Map<Character, Integer> alphabetPositions = new HashMap<>();
        int first = 1;
        for (char c : alphabet) {
            alphabetPositions.put(c, first);
            first += 1;
        }

        return alphabetPositions;
    }
}
