class Solution {
    public int totalNumbers(int[] digits) {

        int[] dp =  new int[10];
        int count  = 0;

        for(int val : digits){
            dp[val]++;
        }

          for(int i  = 100;i<=999;i++){
            int a =  i/100;
            int b = (i/10)%10;
            int c = i%10;

             if (c % 2 != 0) continue;


            if(dp[a]>0){
                dp[a]--;
                if(dp[b]>0){
                    dp[b]--;
                    if(dp[c]>0){
                        count++;
                    }
                    dp[b]++;
                }
                dp[a]++;
            }
            
          }
           return count; 
    }

}