class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] arr = new int[n][3];

        for(int i = 0;i<n;i++){
            arr[i][0]=tasks[i][0]; // enque time
            arr[i][1]=tasks[i][1]; //process time
            arr[i][2]=i; //index of that task // mainly to return the ans in index terms
        }

        Arrays.sort(arr,(a,b) -> Integer.compare(a[0],b[0]));
        
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b)->a[1]==b[1]?a[2]-b[2]:a[1]-b[1]);

        int[] ans = new int[n];

        int i = 0;
        int idx=0;

        long time = 0;

        while(idx<n){

            if(minheap.isEmpty() && time<arr[i][0]){
                time = arr[i][0];
            }

            while(i<n && arr[i][0]<=time){
                minheap.offer(arr[i]);
                i++;
            }

            if(!minheap.isEmpty()){
                int[] task = minheap.poll();
                ans[idx++]=task[2];
                time = time + task[1];

            }
        }
        return ans;
    }
}