class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxIndex = 0;
        int minIndex = 0;
        int n = nums.length;
        int i = 0;
        while(i<nums.length){
              if(nums[i]>max){
                max = Math.max(max,nums[i]);
                maxIndex = i;
            }
              if(min>nums[i]){
                min = Math.min(min,nums[i]);
                minIndex = i;
            }
            i++;

        }
        //hamare pass 3 cases hai mainly
        //remove from left 
        // remove from right 
        // remove from left and right  both

        int left = Math.min(maxIndex,minIndex);
        int right = Math.max(maxIndex,minIndex);
        
        int removefromleft = right + 1;
        int removefromright = n-left;

        int removebothsides = (left + 1) + (n-right);

        return Math.min(removefromleft,Math.min(removefromright,removebothsides));
    }
}