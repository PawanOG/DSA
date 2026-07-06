class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int mincapacity = 0;
        int maxcapacity = 0;

        for(int i = 0;i<weights.length;i++){
            mincapacity = Math.max(mincapacity,weights[i]);
            maxcapacity = maxcapacity + weights[i];
        }

        int answer = maxcapacity;

        while(mincapacity<=maxcapacity){
            int midWeight = mincapacity+(maxcapacity-mincapacity)/2;

            if(helper(weights,midWeight)>days){
                mincapacity = midWeight+1;
            }else{
                answer = midWeight;
                maxcapacity = midWeight-1;
            }
            
        }
        return answer;

    }
        

        public static int helper(int[] weights,int midWeight){
            int sumWeight = 0;
            int requireddays = 1;
            for(int i = 0;i<weights.length;i++){
                if(sumWeight + weights[i] <= midWeight){
                    sumWeight = sumWeight+ weights[i];
                }else{
                    requireddays++;
                    sumWeight = weights[i];
                }
            }
            return requireddays;
        }

    
}