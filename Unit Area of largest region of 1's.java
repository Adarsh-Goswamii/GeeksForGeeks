// DFS 

class Area 
{
    static int ans;
    static void DFSREC(int[][] arr, int row, int col, int value, boolean[][] visited, int N, int M)
    {
        visited[row][col]= true;
        ans++;
        
        for(int i=Math.max(0, row-1); i<=Math.min(N-1, row+1); i++)
            for(int j=Math.max(0, col-1); j<=Math.min(M-1, col+1); j++)
                if(!visited[i][j] && arr[i][j]==1)
                    DFSREC(arr, i, j, value, visited, N, M);
    }
    
    static int findMaxArea(int N, int M, int A[][]) 
    {
        boolean[][] visited=new boolean[N][M];
        int ret=0;
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(!visited[i][j] && A[i][j]==1)
                {   
                    ans=0;
                    DFSREC(A, i, j, 0, visited, N, M);
                    ret= Math.max(ans, ret);
                }
            }
        }
        
        return ret;
    }
}

// BFS
