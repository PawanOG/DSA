class KthLargest {
    
    PriorityQueue<Integer> minheap = new PriorityQueue<>();
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
    for(int num : nums){
        if(minheap.size()<k){
            minheap.offer(num);
        }else if(minheap.peek()<num){
            minheap.poll();
            minheap.offer(num);
        }
    }
    }
    
    public int add(int val) {  
      if(minheap.size()<k){
        minheap.offer(val);
      }else if(minheap.peek()<val){
        minheap.poll();
        minheap.offer(val);
      }
      return minheap.peek();
    }
    
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */