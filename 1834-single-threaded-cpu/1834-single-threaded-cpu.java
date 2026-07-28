import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        // {enqueueTime, processingTime, originalIndex}
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        // Sort by enqueue time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Min Heap: processing time -> index
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[1] != b[1]
                    ? Integer.compare(a[1], b[1])
                    : Integer.compare(a[2], b[2])
        );

        int[] ans = new int[n];
        int i = 0;
        int k = 0;
        long time = 0;

        while (k < n) {

            // If no task is available, jump to the next enqueue time
            if (minHeap.isEmpty() && time < arr[i][0]) {
                time = arr[i][0];
            }

            // Add all available tasks to the heap
            while (i < n && arr[i][0] <= time) {
                minHeap.offer(arr[i]);
                i++;
            }

            // Execute the task with the smallest processing time
            int[] task = minHeap.poll();
            ans[k++] = task[2];
            time += task[1];
        }

        return ans;
    }
}