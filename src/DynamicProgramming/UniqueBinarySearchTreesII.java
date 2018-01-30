/*
Given A, how many structurally unique BST’s (binary search trees) that store values 1...A?

Example :

Given A = 3, there are a total of 5 unique BST’s.


   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */
package DynamicProgramming;

public class UniqueBinarySearchTreesII {
    public static int numTrees(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] numTrees = new int[n+1];
        numTrees[0] = 1;
        numTrees[1] = 1;
        for (int i = 2; i <= n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                numTrees[i] += numTrees[j]*numTrees[i-j-1];
            }
        }
        return numTrees[n];

    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
