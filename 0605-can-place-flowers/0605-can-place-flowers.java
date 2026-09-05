class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int f = flowerbed.length;

        for(int i = 0;i<f;i++){
            boolean left  = i == 0 ||  flowerbed[i-1] ==0;
            boolean right = i ==  f-1 || flowerbed[i+1]==0;

            if(right && left && flowerbed[i]==0){
                flowerbed[i]=1;
                n--;
            }
        }
        return n<=0;
    }
}