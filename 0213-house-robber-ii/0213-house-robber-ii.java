

class Solution {
    int[] dp;

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        if (n == 2)
            return Math.max(nums[0], nums[1]);

        return Math.max(OnetoNminus1(nums), TwotoN(nums));
    }

    public int OnetoNminus1(int[] nums) {
        int n = nums.length;

        dp = new int[n - 1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 2];
    }

    public int TwotoN(int[] nums) {
        int n = nums.length;

        dp = new int[n - 1];

        dp[0] = nums[1];
        dp[1] = Math.max(nums[1], nums[2]);

        for (int i = 3; i < n; i++) {
            dp[i - 1] = Math.max(dp[i - 3] + nums[i], dp[i - 2]);
        }

        return dp[n - 2];
    }
}