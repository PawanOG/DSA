class Solution {
    public int jump(int[] nums) {
        int currentend = 0;
        int maxreach = 0;
        int count = 0;

        for(int i = 0;i<nums.length-1;i++){
            maxreach = Math.max(nums[i]+i,maxreach);
            if(i == currentend){
               count++;
               currentend = maxreach;
            }
        }
        return count;
    }
}