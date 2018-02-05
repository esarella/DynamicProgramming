/*
Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example :
edit distance between
"Anshuman" and "Antihuman" is 2.

Operation 1: Replace s with t.
Operation 2: Insert i.
 */
package Interviews;

public class EditDistance {

    public static int minDistance(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }

        int[][] minDistance = new int[A.length() + 1][B.length() + 1];
        minDistance[0][0] = 0;

        //Initialization of boundary
        for (int i = 1; i <= A.length(); i++) {
            minDistance[i][0] = i;
        }
        for (int i = 1; i <= B.length(); i++) {
            minDistance[0][i] = i;
        }

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    minDistance[i][j] = Math.min(Math.min(minDistance[i - 1][j - 1],
                            minDistance[i - 1][j] + 1), minDistance[i][j - 1] + 1);
                } else {
                    minDistance[i][j] = Math.min(Math.min(minDistance[i - 1][j - 1] + 1,
                            minDistance[i - 1][j] + 1), minDistance[i][j - 1] + 1);
                }
            }
        }
        return minDistance[A.length()][B.length()];
    }

    public static void main(String[] args) {
        String string1 = "Anshuman";
        String string2 = "Antihuman";

        System.out.println(
                "Min Distance of Strings \"" + string1 + "\" and \"" + string2 + "\" = " + minDistance(string1, string2));

    }
}
