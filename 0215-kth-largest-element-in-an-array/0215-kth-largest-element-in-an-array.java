class Solution {
    public int findKthLargest(int[] nums, int k) {
       
       PriorityQueue<Integer> minheap = new PriorityQueue<>();
       
        for(int ch : nums){
        if(minheap.size()<k){
            minheap.offer(ch);
        }else if(minheap.peek()<ch){
               minheap.poll();
               minheap.offer(ch);
        }
       }
       return minheap.peek();
    }
}