class Solution {
    public List<Integer> findMissingElements(int[] nums) {

      Arrays.sort(nums);
      List<Integer> ans = new ArrayList<>();

      for(int i = 1;i<nums.length;i++){
        while(nums[i-1]+1!=nums[i]){
           ans.add(nums[i-1]+1);
           nums[i-1]++;
        }
      }
      return ans;
    }
}