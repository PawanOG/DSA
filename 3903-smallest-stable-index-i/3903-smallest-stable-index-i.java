class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int i = 0;

        while (i < nums.length) {

            int max = nums[0];
            int min = nums[i];

            // max(nums[0..i])
            for (int j = 0; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }

           
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
            }

            if (max - min <= k) {
                return i;
            }

            i++;
        }

        return -1;
    }
}