package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostFrequentSubstring {

    static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {
        int sLength = s.length();
        int max = 0;

        Map<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < sLength; i++) {
            for (int j = minLength; j <= maxLength && i + j <= sLength; j++) {
                String subString = s.substring(i, i + j);

                long uniqueChars = 0;
                Set<Character> unique = new HashSet<>();
                for (Character chars : subString.toLowerCase().toCharArray()) {
                    if (unique.add(chars)) {
                        uniqueChars++;
                    }
                }

                if (uniqueChars <= maxUnique) {
                    hashMap.put(subString, hashMap.getOrDefault(subString, 0) + 1);
                    max = Math.max(hashMap.get(subString), max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
