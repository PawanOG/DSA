class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] ans = new int[m];

        // last[j] = index in word1 where word2[j...]
        // can be matched from right to left.
        int[] last = new int[m];

        Arrays.fill(last, -1);

        int i = n - 1;
        int j = m - 1;

        // Build suffix information
        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        // We can use at most one mismatch
        boolean canChange = true;

        i = 0;
        j = 0;

        while (i < n && j < m) {

            // Case 1: exact match
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;
            }

            // Case 2: use our one mismatch
            else if (canChange &&
                    (j == m - 1 || i < last[j + 1])) {

                ans[j] = i;
                j++;

                canChange = false;
            }

            i++;
        }

        // Could not construct the complete sequence
        if (j < m) {
            return new int[0];
        }

        return ans;
    }
}