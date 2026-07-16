class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i<nums.length){
            int correct = nums[i]-1;
          if(nums[i]==nums[correct]){
            i++;
          }else{
            swap(nums,i,correct);
          }
        }

        return nums[nums.length-1];
        
    }

    static void swap(int[] arr, int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second]= temp;
    }
}