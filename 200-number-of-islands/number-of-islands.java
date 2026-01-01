class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    //bfs(i,j,grid,vis);
                    dfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] vis){
        int m = grid.length, n = grid[0].length;
        vis[i][j] = true;
        if(i-1>=0 && grid[i-1][j]=='1' && vis[i-1][j]==false) 
            dfs(i-1,j,grid,vis);
        if(i+1<=m-1 && grid[i+1][j]=='1' && vis[i+1][j]==false) 
            dfs(i+1,j,grid,vis);
        if(j-1>=0 && grid[i][j-1]=='1' && vis[i][j-1]==false) 
            dfs(i,j-1,grid,vis);
        if(j+1<=n-1 && grid[i][j+1]=='1' && vis[i][j+1]==false) 
            dfs(i,j+1,grid,vis);
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] vis){
        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        while(q.size()>0){
            Pair front = q.remove();
            int row = front.row, col = front.col;
            if(row>0){
                if(vis[row-1][col]==false && grid[row-1][col]=='1'){
                    q.add(new Pair(row-1,col));
                    vis[row-1][col] = true;
                }
            }
            if((row+1)<m){
                if(vis[row+1][col]==false && grid[row+1][col]=='1'){
                    q.add(new Pair(row+1,col));
                    vis[row+1][col] = true;
                }
            }
            if(col>0){
                if(vis[row][col-1]==false && grid[row][col-1]=='1'){
                    q.add(new Pair(row,col-1));
                    vis[row][col-1]=true;
                }
            }
            if((col+1)<n){
                if(vis[row][col+1]==false && grid[row][col+1]=='1'){
                    q.add(new Pair(row,col+1));
                    vis[row][col+1]=true;
                }
            }
        }
    }
}