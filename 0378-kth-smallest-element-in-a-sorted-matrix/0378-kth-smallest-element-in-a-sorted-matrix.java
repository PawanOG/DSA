class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

         while(low<high){
            int mid = low + (high - low) / 2;
        int count  = 0;

           

            for(int i = 0;i<matrix.length;i++){
                for(int j = 0;j<matrix[0].length;j++){
                    if(mid>=matrix[i][j]){
                        count++;
                    }else{
                        break;
                    }
                }
                
            }
            if(count<k){
                low = mid+1;
            }
            else{
                high = mid;
            }
            
             
        }
        return low;
    }

}