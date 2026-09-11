class Solution {
    public int[] findEvenNumbers(int[] digits) {

        int[] dp = new int[10];

        for (int val : digits) {
            dp[val]++;
        }

        int[] ans = new int[1000];
        int idx = 0;

        for (int i = 100; i <= 999; i++) {

            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;

            if (c % 2 != 0) continue;

            if (dp[a] > 0) {
                dp[a]--;

                if (dp[b] > 0) {
                    dp[b]--;

                    if (dp[c] > 0) {
                        ans[idx] = i;
                        idx++;
                    }

                    dp[b]++;
                }

                dp[a]++;
            }
        }

        return Arrays.copyOf(ans, idx);
    }
}