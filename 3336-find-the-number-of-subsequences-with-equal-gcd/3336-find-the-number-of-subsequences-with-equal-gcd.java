class Solution {
    int MOD = 1000000007;

    public int subsequencePairCount(int[] nums) {
        int MAX = 200;

        // dp[g1][g2] = ways where gcd of seq1 = g1 and gcd of seq2 = g2
        long[][] dp = new long[MAX + 1][MAX + 1];
        dp[0][0] = 1; // Dono subsequence abhi empty hain

        for (int num : nums) {

            // Har number ke liye naya DP banayenge
            long[][] next = new long[MAX + 1][MAX + 1];

            for (int g1 = 0; g1 <= MAX; g1++) {
                for (int g2 = 0; g2 <= MAX; g2++) {

                    if (dp[g1][g2] == 0)
                        continue;

                    long ways = dp[g1][g2];

                    // Case 1: Current number ko ignore kar do
                    next[g1][g2] = (next[g1][g2] + ways) % MOD;

                    // Case 2: Current number seq1 me daal do
                    int newG1 = (g1 == 0) ? num : gcd(g1, num);
                    next[newG1][g2] = (next[newG1][g2] + ways) % MOD;

                    // Case 3: Current number seq2 me daal do
                    int newG2 = (g2 == 0) ? num : gcd(g2, num);
                    next[g1][newG2] = (next[g1][newG2] + ways) % MOD;
                }
            }

            dp = next;
        }

        long ans = 0;

        // Sirf wahi states count karni hain jahan gcd same ho
        // Aur dono subsequence non-empty hon (gcd != 0)
        for (int g = 1; g <= MAX; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }

        return (int) ans;
    }

    // Euclid Algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}