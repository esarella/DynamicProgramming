/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example :

Input : 3
Return : 3

Steps : [1 1 1], [1 2], [2 1]

 */
package DynamicProgramming;

public class Stairs {

    public static int climbStairs(int A) {
        if(A <= 0) return 0;
        if (A == 1) return 1;
        if(A == 2) return 2;

        int[] count = new int[A + 1];

        count[0] = 0;
        count[1] = 1;
        count[2] = 2;


        for(int i = 3; i <= A; i++) {
            count[i] = count[i - 1] + count[i - 2];
        }

        return count[A];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
