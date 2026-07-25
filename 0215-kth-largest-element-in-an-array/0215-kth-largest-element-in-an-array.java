class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for(int num:nums){
            if(minheap.size()<k){
                minheap.offer(num);
            }else if(num>minheap.peek()){
                minheap.poll();
                minheap.offer(num);
            }
        }
        return minheap.peek();
    }
}