class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(0,rooms,visited);
        for(boolean ele : visited){
            if(ele==false) return false;
        }
        return true;
    }

    public void dfs(int start, List<List<Integer>> rooms, boolean[] visited){
        visited[start] = true;
        for(int ele : rooms.get(start)){
            if(!visited[ele]) dfs(ele,rooms,visited);
        }
    }

    public void bfs(int start, List<List<Integer>> rooms, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(q.size()>0){
            int front = q.remove();
            for(int ele : rooms.get(front)){
                if(!visited[ele]){
                    visited[ele] = true;
                    q.add(ele);
                }
            }
        }
    }
}