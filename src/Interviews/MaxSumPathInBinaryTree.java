/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example :

Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
package Interviews;

public class MaxSumPathInBinaryTree {


    private static int maxSumPath;
    private static int count = 0;

    public static int maxPathSum(TreeNode A) {

        maxSumPath = Integer.MIN_VALUE;

//        traverse(A);
        traverseII(A);
        return maxSumPath;
    }

    private static int traverse(TreeNode A) {
        if (A == null) return 0;

        int leftMax = traverse(A.left);
        int rightMax = traverse(A.right);

        maxSumPath = Math.max(maxSumPath, A.val + leftMax);
        maxSumPath = Math.max(maxSumPath, A.val + rightMax);
        maxSumPath = Math.max(maxSumPath, A.val + leftMax + rightMax);
        maxSumPath = Math.max(maxSumPath, A.val);

        return Math.max(Math.max(A.val, A.val + leftMax), A.val + rightMax);

    }

    private static int traverseII(TreeNode A) {
        if (A == null) return 0;
        count++;
        int left = Math.max(traverseII(A.left), 0);
        int right = Math.max(traverseII(A.right), 0);

        maxSumPath = Math.max(maxSumPath, left + right + A.val);
        return Math.max(left, right) + A.val;
    }

    public static void main(String[] args) {

        /*

            1
           / \
          2   3
         / \ / \
        2  4 2  3

        */
        TreeNode nodeRoot = new TreeNode(1);
        TreeNode nodeLeft = new TreeNode(2);
        TreeNode nodeRight = new TreeNode(3);

        TreeNode leaf1 = new TreeNode(2);
        TreeNode leaf2 = new TreeNode(4);
        TreeNode leaf3 = new TreeNode(2);
        TreeNode leaf4 = new TreeNode(3);


        nodeRoot.left = nodeLeft;
        nodeRoot.right = nodeRight;

        nodeLeft.left = leaf1;
        nodeLeft.right = leaf2;
        nodeRight.left = leaf3;
        nodeRight.right = leaf4;

        System.out.println(maxPathSum(nodeRoot));
        System.out.println("Count = " + count);
    }

    //  Definition for binary tree
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
