class Solution {
    public int longestOnes(int[] nums, int k) {

        int num_zeroes = 0;
        int left = 0;
        int ans = 0;

        for(int right = 0;right<nums.length;right++){
            if(nums[right]==0){
                num_zeroes++;
            }
            while(num_zeroes>k){
                if(nums[left]==0){
                    num_zeroes--;
                }
                left++;
            }

        ans = Math.max(ans,right-left+1);

        }
        
        return ans;
    }
}