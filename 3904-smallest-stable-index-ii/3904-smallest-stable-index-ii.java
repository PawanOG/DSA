class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] min = new int[n];

        min[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
        }

        int i = 0;
        int max = Integer.MIN_VALUE;
        while (i < nums.length) {

            max = Math.max(max, nums[i]);

            if (max - min[i] <= k) {
                return i;
            }
            i++;
        }
        return -1;
    }
}