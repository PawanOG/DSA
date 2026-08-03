class Solution {

    Integer[] dp;

    public String stoneGameIII(int[] stoneValue) {

        dp = new Integer[stoneValue.length];

        int result = solve(0, stoneValue);

        if (result > 0) {
            return "Alice";
        } else if (result < 0) {
            return "Bob";
        }
        return "Tie";
    }

    public int solve(int i, int[] stoneValue) {

        // Alice's score - Bob's score

        if (i >= stoneValue.length) {
            return 0;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        int diff = Integer.MIN_VALUE;

        // Take 1 stone
        diff = Math.max(diff,
                stoneValue[i] - solve(i + 1, stoneValue));

        // Take 2 
        if (i + 1 < stoneValue.length) {
            diff = Math.max(diff,
                    stoneValue[i] + stoneValue[i + 1]
                            - solve(i + 2, stoneValue));
        }

        // 3
        if (i + 2 < stoneValue.length) {
            diff = Math.max(diff,
                    stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2]
                            - solve(i + 3, stoneValue));
        }

        return dp[i] = diff;
    }
}