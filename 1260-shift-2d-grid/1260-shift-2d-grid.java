class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] ans = new int[m][n];
    int total = m*n;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                //converting 2d matrix into 1d 
                int currindex = i*n+j;

                //now assigning the elements new indexes as per the k value n 1d array
                int newindex = (currindex+k)%total;

                //now converting this 1d to 2d
                int newRow = newindex/n;
                int newCol =newindex%n;

                ans[newRow][newCol]= grid[i][j];

            }

        }
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0;i<m;i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0;j<n;j++){
                row.add(ans[i][j]);
            }
            result.add(row);
        }
        return result;
    }
}