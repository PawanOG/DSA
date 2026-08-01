

class Solution {

    public boolean predictTheWinner(int[] nums) {
        int sum = 0;

        for (int x : nums)
            sum += x;

        int p1 = solve(0, nums.length - 1, nums);
        int p2 = sum - p1;

        return p1 >= p2;
    }

    private int solve(int i, int j, int[] nums) {

        if (i > j)
            return 0;

        if (i == j)
            return nums[i];

        //refer to  notes for this part 
        //mainly we are choosing the worst possible conditions opponent left for us after his turn we taking minimun 

        int takeLeft = nums[i] +
                Math.min(
                        solve(i + 2, j, nums),
                        solve(i + 1, j - 1, nums));

        int takeRight = nums[j] +
                Math.min(
                        solve(i + 1, j - 1, nums),
                        solve(i, j - 2, nums));

        return Math.max(takeLeft, takeRight);
    }
}