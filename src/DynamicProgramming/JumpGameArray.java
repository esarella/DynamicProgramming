/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return 1 ( true ).

A = [3,2,1,0,4], return 0 ( false ).

Return 0/1 for this problem
 */
package DynamicProgramming;

public class JumpGameArray {
    public static void main(String[] args) {

    }

    public int canJump(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int maxJump = A[0];
        for (int i = 1; i < A.length; i++) {
            if (maxJump >= i)
                maxJump = Math.max(maxJump, i + A[i]);
            if (maxJump >= A.length - 1)
                break;
        }
        return (maxJump >= A.length - 1) ? 1 : 0;
    }
}
