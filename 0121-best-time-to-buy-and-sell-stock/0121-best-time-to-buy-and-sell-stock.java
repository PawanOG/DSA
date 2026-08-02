

class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int buyday = prices[0];

        for(int i = 1;i<prices.length;i++){
           if(prices[i]>buyday){
           maxprofit = Math.max(maxprofit,prices[i]-buyday);
           }
           buyday =  Math.min(buyday,prices[i]);
           }
        return maxprofit;
    }
}