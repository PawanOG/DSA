import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0]; // enqueue time
            arr[i][1] = tasks[i][1]; // processing time
            arr[i][2] = i;           // original index
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1])
                    return Integer.compare(a[2], b[2]);
                return Integer.compare(a[1], b[1]);
            }
        );

        int[] ans = new int[n];
        int i = 0, idx = 0;
        long time = 0;

        while (idx < n) {

            // If no available task, move time forward
            if (minHeap.isEmpty() && time < arr[i][0]) {
                time = arr[i][0];
            }

            // Add all available tasks
            while (i < n && arr[i][0] <= time) {
                minHeap.offer(arr[i]);
                i++;
            }

            // Execute shortest task
            if (!minHeap.isEmpty()) {
                int[] task = minHeap.poll();
                ans[idx++] = task[2];
                time += task[1];
            }
        }

        return ans;
    }
}