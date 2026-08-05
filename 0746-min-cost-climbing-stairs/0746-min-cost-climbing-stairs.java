class Solution {
    int[] dp;

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        dp = new int[n];
         Arrays.fill(dp, -1);


        return Math.min(
                mincost(cost, n - 1) + cost[n - 1],
                mincost(cost, n - 2) + cost[n - 2]
        );

    }

    public int mincost(int[] cost, int i) {

        if (i <= 1) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = Math.min(cost[i - 1] + mincost(cost, i - 1),
                         cost[i - 2] + mincost(cost, i - 2));

        return dp[i];
    }
}