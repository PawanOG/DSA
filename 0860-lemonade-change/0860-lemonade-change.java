class Solution {
    public boolean lemonadeChange(int[] bills) {

        //taking an array where index 0 denotes number of 5 dollar bills
        // idx 1 denotes no. of 10 dollar bills

        int[] change = new int[2];

        for(int i = 0;i<bills.length;i++){
            if(bills[i]==5){
                change[0]++;
            }else if(bills[i]==10){
                change[0]--;
                change[1]++;
                if(change[0]<0){
            return false;
        }
            }else{
                if(change[1]!=0){
                    change[1]--;
                    change[0]--;
                    if(change[0]<0){
            return false;
        }
                }else{
                    change[0]--;
                    change[0]--;
                    change[0]--;
                    if(change[0]<0){
            return false;
        }
                }
            }
        }

        return true;
        
    }
}