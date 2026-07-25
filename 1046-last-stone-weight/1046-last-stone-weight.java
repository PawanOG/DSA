import java.util.Arrays;

class Solution {
    public int lastStoneWeight(int[] stones) {

        int n = stones.length;

        while (n > 1) {
            Arrays.sort(stones, 0, n);

            int y = stones[n - 1]; // largest
            int x = stones[n - 2]; // second largest

            if (y == x) {
                n -= 2; // both destroyed
            } else {
                stones[n - 2] = y - x; // replace second largest
                n--; 
            }
        }

        return n == 0 ? 0 : stones[0];
    }
}