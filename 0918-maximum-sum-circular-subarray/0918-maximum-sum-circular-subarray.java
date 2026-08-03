class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalsum = 0;
        for (int num : nums) {
            totalsum += num;
        }
        int min = minSubarraySum(nums);
        int max = maxSubarraySum(nums);
        int circularsum = totalsum - min;

        if(max>0){
            return Math.max(max,circularsum);
        }else return max;

    }

    public int minSubarraySum(int[] nums) {
        int currMin = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currMin = Math.min(nums[i], currMin + nums[i]);
            minSum = Math.min(minSum, currMin);
        }

        return minSum;
    }

    public int maxSubarraySum(int[] nums) {
        int currmax = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currmax = Math.max(nums[i], currmax + nums[i]);
            maxSum = Math.max(maxSum, currmax);
        }

        return maxSum;
    }

}