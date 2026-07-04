import java.util.*;

class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Create buckets
        ArrayList<Character>[] bucket = new ArrayList[s.length() + 1];

        for (char ch : map.keySet()) {
            int freq = map.get(ch);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(ch);
        }

        // Step 3: Build answer
        StringBuilder ans = new StringBuilder();

        for (int i = bucket.length - 1; i >= 1; i--) {

            if (bucket[i] != null) {

                for (char ch : bucket[i]) {

                    for (int j = 0; j < i; j++) {
                        ans.append(ch);
                    }
                }
            }
        }

        return ans.toString();
    }
}