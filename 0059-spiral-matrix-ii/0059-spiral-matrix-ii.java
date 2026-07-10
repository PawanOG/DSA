class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int value = 1;
        int dir = 0;

        while (top <= bottom && left <= right) {

            if (dir == 0) { // left to right
                for (int i = left; i <= right; i++) {
                    ans[top][i] = value++;
                }
                top++;
            } 
            else if (dir == 1) { // top to bottom
                for (int i = top; i <= bottom; i++) {
                    ans[i][right] = value++;
                }
                right--;
            } 
            else if (dir == 2) { // right to left
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = value++;
                }
                bottom--;
            } 
            else if (dir == 3) { // bottom to top
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = value++;
                }
                left++;
            }

            dir = (dir + 1) % 4;
        }

        return ans;
    }
}
