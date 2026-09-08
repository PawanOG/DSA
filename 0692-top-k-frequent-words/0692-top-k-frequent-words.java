class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String ch : words) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>(
                (a, b) -> {
                    if (map.get(a).equals(map.get(b))) {
                        return b.compareTo(a);
                    }
                    return map.get(a) - map.get(b);
                });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();

            if (heap.size() < k) {
                heap.offer(key);
            } else if (map.get(key) > map.get(heap.peek()) ||
                    (map.get(key).equals(map.get(heap.peek())) &&
                            key.compareTo(heap.peek()) < 0)) {
                heap.poll();
                heap.offer(key);
            }
        }

        int i = k - 1;
        String[] ans = new String[k];
        while (!heap.isEmpty()) {
            ans[i--] = heap.poll();
        }

        return Arrays.asList(ans);
    }
}