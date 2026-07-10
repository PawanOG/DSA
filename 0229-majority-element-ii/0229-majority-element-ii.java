import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        ArrayList<Integer> ans = new ArrayList<>();

        int count1 = 0;
        int count2 = 0;

        int majorityele1 = 0;
        int majorityele2 = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == majorityele1) {
                count1++;
            } else if (nums[i] == majorityele2) {
                count2++;
            } else if (count1 == 0) {   
                majorityele1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                majorityele2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == majorityele1) {
                count1++;
            } else if (num == majorityele2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            ans.add(majorityele1);
        }

        if (count2 > nums.length / 3) {
            ans.add(majorityele2);
        }

        return ans;
    }
}