

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] changesinlocation = new int[1001];

        for(int[] trip : trips){
           int passengers = trip[0];
           int from = trip[1];
           int to = trip[2];
           
           changesinlocation[from] = changesinlocation[from] + passengers;
           changesinlocation[to] = changesinlocation[to] - passengers; 
        }

        int usedcapacity=0;

        for(int changeincapacity : changesinlocation ){
            usedcapacity = usedcapacity + changeincapacity;
            if(usedcapacity>capacity){
                return false;
            }
        }
        return true;

        
    }
}