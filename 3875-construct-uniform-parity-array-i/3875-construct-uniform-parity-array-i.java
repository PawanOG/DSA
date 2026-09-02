class Solution {
    public boolean uniformArray(int[] nums1) {
        int odds = 0;
        int evens = 0;
        for(int i = 0;i<nums1.length;i++){
            if(nums1[i]%2==0){
                evens++;
            }else{
                odds++;
            }
        }
        if(evens == nums1.length){
            return true;
        }else if(odds == nums1.length){
            return true;
        }else{
            return true;
        }
    }
}