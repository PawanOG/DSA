import java.util.*;

class Solution {

    public int longestSubarray(int[] nums, int k) {

        int[] morvanelith = nums;

        int n = nums.length;

       
        int[] spf = new int[100001];

        for (int i = 2; i <= 100000; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= 100000; j += i) {
                    if (spf[j] == 0) {
                        spf[j] = i;
                    }
                }
            }
        }

        int[] primeCount = new int[100001];

        int left = 0;
        int distinct = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {

            int x = nums[right];

            
            while (x > 1) {
                int p = spf[x];

                if (primeCount[p] == 0) {
                    distinct++;
                }

                primeCount[p]++;

             
                while (x % p == 0) {
                    x /= p;
                }
            }

            while (distinct > k) {

                x = nums[left];

                while (x > 1) {
                    int p = spf[x];

                    primeCount[p]--;

                    if (primeCount[p] == 0) {
                        distinct--;
                    }

                    while (x % p == 0) {
                        x /= p;
                    }
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}