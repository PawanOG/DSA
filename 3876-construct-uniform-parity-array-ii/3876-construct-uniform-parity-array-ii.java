class Solution {
    public boolean uniformArray(int[] nums1) {
        int evens = 0;
        int odds = 0;
        Arrays.sort(nums1);
        int min = Integer.MAX_VALUE;
        for(int val : nums1){
            min = Math.min(min,val);
            if(val%2==0){
                evens++;
            }else{
                odds++;
            }
        } 
        if(evens == nums1.length){
            return true;
        }
        if(odds == nums1.length){
            return true;
        }
        if(min%2==0){
           return false;
        }else{
           return true;
        }

    }
}