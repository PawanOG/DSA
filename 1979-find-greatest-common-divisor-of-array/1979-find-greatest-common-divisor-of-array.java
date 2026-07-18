class Solution {
    public int findGCD(int[] nums) {
        int i = 0;
        int min = 1001;
        int max = 0;
        while(i<nums.length){
        max = Math.max(nums[i],max);
        min = Math.min(nums[i],min);
        i++;
        }
        //euclid theorem 
        return gcd(max,min);
        
    }

    public int gcd(int a , int b){
        while(b!=0){
        int temp = b;
        b = a%b;
        a = temp;
    }
    return a;
}
}