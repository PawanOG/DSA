class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int start = 1;

        // Find the maximum element
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            end = Math.max(end, nums[i]);
        }

        int ans = end;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int sum = divideResult(nums, mid);

            if (sum <= threshold) {
                ans = mid;        
                end = mid - 1;    
            } else {
                start = mid + 1;  
            }
        }

        return ans;
    }

    public int divideResult(int[] nums, int divisor) {
        int sum = 0;

        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; 
        }

        return sum;
    }
}