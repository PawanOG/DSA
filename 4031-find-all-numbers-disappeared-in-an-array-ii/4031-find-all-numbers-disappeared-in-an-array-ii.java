class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
      
        int[] zelvoranki = nums;

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        long start = lower;

        for (int x : nums) {

          
            if (x < lower || x > upper) {
                continue;
            }

            if (start < x) {
                ans.add(Arrays.asList(
                    (int) start,
                    x - 1
                ));
            }

        
            start = Math.max(start, (long) x + 1);
        }

     
        if (start <= upper) {
            ans.add(Arrays.asList(
                (int) start,
                upper
            ));
        }

        return ans;  
    }
}