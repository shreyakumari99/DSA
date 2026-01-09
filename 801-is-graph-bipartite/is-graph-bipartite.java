// Bipartite - when we can colour each node of the graph with either red or blue & adjacent nodes must have different color. In both sets, elements should not connected to each other.
       // graph which does not contain cycle will always be bipartite.
class Solution {
    static boolean ans;
    public void bfs(int i, int[][] adj, int[] visited){
        Queue<Integer> q = new LinkedList<>();
        visited[i] = 0; // 1 -> red, 0 means blue
        q.add(i);
        while(q.size()>0){
            int front = q.remove();
            int color = visited[front];
            for(int ele : adj[front]){
                if(visited[ele]==visited[front]){
                    ans = false;
                    return;
                }
                if(visited[ele]==-1){
                    visited[ele] = 1-color;
                    q.add(ele);
                }
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
       ans = true;
       int n = graph.length;
       int[] visited = new int[n];
       Arrays.fill(visited,-1); 
       for(int i=0; i<n; i++){
          if(ans==false) return ans;
          if(i==0 || visited[i]==-1) bfs(i,graph,visited);
       }
       return ans;
    }
}