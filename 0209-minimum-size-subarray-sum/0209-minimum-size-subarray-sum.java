class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int right = 0;
        int left = 0;
        int n = nums.length;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        while (right < n) {

            sum = sum + nums[right];
            while(sum >= target) {
                length = Math.min(length, right-left + 1);
                sum = sum - nums[left];
                left++;
            }
            right++;

        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}