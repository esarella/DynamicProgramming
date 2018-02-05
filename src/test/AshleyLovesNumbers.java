package test;

import java.util.HashSet;
import java.util.Set;

public class AshleyLovesNumbers {
    static void countNumbers(int[][] arr) {

        int cnt = arr.length;

        for (int i = 0; i < cnt; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            int count = 0;
            for (int j = start; j <= end; j++) {
                char[] charArray = String.valueOf(j).toCharArray();
                Set<Character> hashSet = new HashSet<>();
                boolean found = true;

                for (char c : charArray) {
                    if (hashSet.contains(c)) {
                        found = false;
                        break;
                    }
                    hashSet.add(c);
                }
                if (found) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {

    }
}
