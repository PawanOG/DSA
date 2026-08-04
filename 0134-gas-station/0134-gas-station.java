

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int[] gain = new int[cost.length];
        int totalcost = 0;
        int totalgas = 0;
        int currentgain = 0;
        int start = 0;
        //ham har station ka gain ,gain array ke usi index pe store krde denge jis index pe station h
        for (int i = 0; i < cost.length; i++) {
            gain[i] = gas[i] - cost[i];
            totalcost += cost[i];
            totalgas += gas[i];
        }

        if (totalcost > totalgas) {
            return -1;
        } else {
            //now we are trying to find the station which will be best for our stating point
            for (int i = 0; i < gain.length; i++) {
                currentgain += gain[i];
                if (currentgain < 0) {
                    currentgain = 0;
                    start = i + 1;
                }
            }
        }
        return start;
    }
}