class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]]) -
                      (nums1[b[0]] + nums2[b[1]])
        );

        int i = 0;

        while (i < nums1.length && i < k) {
            heap.add(new int[]{i, 0});
            i++;
        }

        List<List<Integer>> ans = new ArrayList<>();

        while (k > 0 && !heap.isEmpty()) {

            int[] curr = heap.poll();

            int row = curr[0];
            int col = curr[1];

            ans.add(Arrays.asList(nums1[row], nums2[col]));

            if (col + 1 < nums2.length) {
                heap.add(new int[]{row, col + 1});
            }

            k--;
        }

        return ans;
    }
}