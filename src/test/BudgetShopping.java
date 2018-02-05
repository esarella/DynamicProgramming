package test;

public class BudgetShopping {
    static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {
        int[] dp = new int[n + 1];

        for (int i = 0; i < bundleQuantities.length; i++) {
            for (int j = bundleCosts[i]; j <= n; j++) {
                int temp = j - bundleCosts[i];
                dp[j] = Math.max(dp[j], dp[temp] + bundleQuantities[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
