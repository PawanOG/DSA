class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:prerequisites){
            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        
        Queue<Integer> que = new LinkedList<>();
        

        for(int i = 0;i<indegree.length;i++){
            if(indegree[i]==0){
            que.add(i);
            }
        } 

        int count = 0;

        while(!que.isEmpty()){
            
            int node = que.poll();
            count++;
            
            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    que.add(neighbour);
                }
            }
            
        }
        return count == numCourses;
    }
}