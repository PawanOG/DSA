class Solution {
    public int maximumProduct(int[] nums) {

        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        //for ex; -10,-10,4,5 in this example maximun multiple will be of -10,-10,5 so we have to code in such a way to find multiple of (3 largest) and (1 largest and 2 smallest) and the max between these two will be my answer
        for(int num : nums){
        //pehle 3 largest numbers find krlo
        if (max1<num){
            max3=max2;
            max2=max1;
            max1=num;
        }else if(num>max2){
            max3=max2;
            max2=num;
        }else if(max3<num){
            max3=num;
        }

        //then finding the 2 smallest
        if(num<min1){
            min2=min1;
            min1=num;
        }else if(num<min2){
            min2=num;
        }
        }
        int ans = Math.max(max1*max2*max3,min1*min2*max1);

        return ans;
    }
}