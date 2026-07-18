class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for(int i = 0;i<nums.length;i++){
            low = Math.max(low,nums[i]);
            high = high + nums[i];
        } 

        int ans = high;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(cansplit(nums,k,mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    private boolean cansplit(int[] nums,int k,int limit){

        int currsum = 0;
        int parts = 1;

        for(int num:nums){
            if(currsum + num<=limit){
               currsum+=num;
            }else{
                parts++;
                currsum = num;
            }
        }
            return parts<=k;
    }
}