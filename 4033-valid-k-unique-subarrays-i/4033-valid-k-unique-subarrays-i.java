import java.util.*;

class Solution {
    
    static class Query {
        int l;
        int r;
        int idx;

        Query(int l, int r, int idx) {
            this.l = l;
            this.r = r;
            this.idx = idx;
        }
    }

    public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {

        int n = nums.length;
        int q = queries.length;

        Query[] arr = new Query[q];

        for (int i = 0; i < q; i++) {
            arr[i] = new Query(
                queries[i][0],
                queries[i][1],
                i
            );
        }

        int block = (int) Math.sqrt(n);

        Arrays.sort(arr, (a, b) -> {
            int blockA = a.l / block;
            int blockB = b.l / block;

            if (blockA != blockB) {
                return Integer.compare(blockA, blockB);
            }

            if (blockA % 2 == 0) {
                return Integer.compare(a.r, b.r);
            } else {
                return Integer.compare(b.r, a.r);
            }
        });

        int[] freq = new int[100001];

        boolean[] ans = new boolean[q];

        int left = 0;
        int right = -1;

        int distinct = 0;
        int oddCount = 0;

        for (Query query : arr) {

            int L = query.l;
            int R = query.r;

            // Expand left
            while (left > L) {
                left--;

                int val = nums[left];

                if (freq[val] == 0) {
                    distinct++;
                }

                if (freq[val] % 2 == 0) {
                    oddCount++;
                } else {
                    oddCount--;
                }

                freq[val]++;
            }

            // Shrink left
            while (left < L) {

                int val = nums[left];

                if (freq[val] % 2 == 0) {
                    oddCount++;
                } else {
                    oddCount--;
                }

                freq[val]--;

                if (freq[val] == 0) {
                    distinct--;
                }

                left++;
            }

            // Expand right
            while (right < R) {
                right++;

                int val = nums[right];

                if (freq[val] == 0) {
                    distinct++;
                }

                if (freq[val] % 2 == 0) {
                    oddCount++;
                } else {
                    oddCount--;
                }

                freq[val]++;
            }

            // Shrink right
            while (right > R) {

                int val = nums[right];

                if (freq[val] % 2 == 0) {
                    oddCount++;
                } else {
                    oddCount--;
                }

                freq[val]--;

                if (freq[val] == 0) {
                    distinct--;
                }

                right--;
            }

            // Valid if:
            // 1. Exactly k distinct elements
            // 2. Every frequency is even
            ans[query.idx] = (distinct == k && oddCount == 0);
        }

        return ans;
    }
}