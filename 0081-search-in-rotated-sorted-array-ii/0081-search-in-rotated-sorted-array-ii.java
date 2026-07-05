class Solution {
    public boolean search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            //duplicates handle krre h yaha if they exist
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }

            // agar Left half sorted hai then search on left
            else if (nums[start] <= nums[mid]) {

                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            // Right half is sorted hai to right me searching kro
            else {

                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }
}