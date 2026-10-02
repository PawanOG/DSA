class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        // Find connected components
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                DFS(adj, visited, i);
                count++;
            }
        }

        return count;
    }

    void DFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int i) {

        visited[i] = true;

        for (int neighbour : adj.get(i)) {

            if (!visited[neighbour]) {
                DFS(adj, visited, neighbour);
            }
        }
    }
}