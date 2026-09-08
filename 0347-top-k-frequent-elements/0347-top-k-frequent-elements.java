class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];
        HashMap<Integer,Integer> freqs = new HashMap<>();

        for(int val:nums){
            freqs.put(val,freqs.getOrDefault(val,0)+1);
        }

        PriorityQueue<Integer> minheap = new PriorityQueue<>((a,b) -> freqs.get(a) - freqs.get(b));


        for(Map.Entry<Integer,Integer> entry : freqs.entrySet()){
            int num = entry.getKey();
          

            if(minheap.size()<k){
               minheap.offer(num);
            }else if(freqs.get(minheap.peek())<freqs.get(num)){
               minheap.poll();
               minheap.offer(num);
            }
        }
        int i = 0;

        while (!minheap.isEmpty()) {
            ans[i++] = minheap.poll();
        }

        return ans;
    }
}