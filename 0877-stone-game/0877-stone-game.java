class Solution {
     Integer[][] dp;
    public boolean stoneGame(int[] piles) {

        int n = piles.length;
        dp = new Integer[n][n];
        int total = 0;

        for(int x : piles){
            total += x;
        }

        int alicescore = solve(0,n-1,piles);
        int bobscore = total - alicescore;

        if(alicescore>bobscore){
            return true;
        }return false;

        
    }

    public int solve(int i ,int j ,int[] piles){

        if(i==j){
            return piles[i];
        }

        if(i>j){
            return 0;
        }
        
        if (dp[i][j] != null)
            return dp[i][j];
    
        int take_i = piles[i]+Math.min(solve(i+2,j,piles),solve(i+1,j-1,piles));
        int take_j = piles[j]+Math.min(solve(i+1,j-1,piles),solve(i,j-2,piles));

        return dp[i][j]=Math.max(take_i,take_j);
    }
}