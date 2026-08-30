class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int currsum = 0;

        for (int i = 0; i < k; i++) {
            currsum += cardPoints[i];
        }

        int maxscore = currsum;

        int j = cardPoints.length-1;

        for(int i = 1;i<=k ; i++){
           currsum = currsum - cardPoints[k-i];
           currsum = currsum + cardPoints[n-i];

            maxscore = Math.max(currsum,maxscore);
        }
        return maxscore;

    }
}