class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        //agar m * k bada h bloomday array ke length se to hame jitne flowers chiye bouquet utne avaible hi nhi h so return -1 we cannot make bouquet
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int startDay = bloomDay[0];
        int lastDay = bloomDay[0];

        // binary search apply krne ke liye hame ek range chiye hogi so we can take the min day and  the maxday of bloom of a flower and we can find a day between agar hame required adjacent flowers bloom hote milre h to 
        for (int i = 1; i < bloomDay.length; i++) {
            startDay = Math.min(startDay, bloomDay[i]);
            lastDay = Math.max(lastDay, bloomDay[i]);
        }

        int minDay = -1;

        while (startDay <= lastDay) {

            int midDay = startDay + (lastDay - startDay) / 2;

            if (canMakeBouquet(bloomDay, midDay, m, k)) {
                minDay = midDay;
                lastDay = midDay - 1;
            } else {
                startDay = midDay + 1;
            }
        }

        return minDay;
    }
   // we make a helper function to compare out mid day , agar us mid day tak required adjacent flowers bloom ho ja rhe h ya nhi according to that we will shift start and end
    public boolean canMakeBouquet(int[] bloomDay, int midDay, int m, int k) {

        int consecutiveCount = 0;
        int bouquetCount = 0;

        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= midDay) {
                consecutiveCount++;

                if (consecutiveCount == k) {
                    bouquetCount++;
                    consecutiveCount = 0;
                }

            } else {
                consecutiveCount = 0;
            }
        }

        return bouquetCount >= m;
    }
}