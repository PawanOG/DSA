

class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n];

        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        return minSum(grid,0,0);
    }

    public int minSum(int[][] grid,int m , int n){

         if (m >= grid.length || n >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if(m == grid.length-1 && n == grid[0].length-1){
            return grid[m][n];
        }

        if(dp[m][n]!=-1){
            return dp[m][n];
        }


        int down = minSum(grid,m+1,n);
        int right = minSum(grid,m,n+1);

        dp[m][n] = grid[m][n] + Math.min(down,right);

        return dp[m][n];
    }
}