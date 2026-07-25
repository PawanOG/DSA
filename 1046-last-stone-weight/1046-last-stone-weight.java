class Solution {
    public int lastStoneWeight(int[] stones) {
     
     PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
     int k = stones.length;

     for(int stone:stones){
       maxheap.offer(stone);
     }
     while(maxheap.size()>1){
        int a = maxheap.poll();
        int b = maxheap.poll();
        
        maxheap.offer(Math.abs(a-b));
    }
    return maxheap.peek();

    }
}