class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gain = 0;
        int totalgain = 0;
        int currentgain = 0;
        int start = 0;
        for(int i = 0;i<gas.length;i++){
            gain = gas[i]-cost[i];
            totalgain+=gain;
            currentgain+=gain;
            if(currentgain<0){
                currentgain = 0;
                start = i+1;
            }
        }
        return totalgain<0?-1:start;
       
    }
}