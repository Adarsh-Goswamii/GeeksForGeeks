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
class Area 
{
    static int findMaxArea(int N, int M, int A[][]) 
    {
        Queue<Integer> q= new LinkedList<>();
        boolean[][] visited= new boolean[N][M];
        int ret=0;
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(A[i][j]== 1 && !visited[i][j])
                { q.add(i); q.add(j); visited[i][j]= true; }
                
            int ans=0;        
            while(!q.isEmpty())
            {
                int row= q.poll();
                int col= q.poll();
                ans++;
                
                for(int ii= Math.max(0, row-1); ii< Math.min(N, row+2); ii++)
                {
                    for(int jj= Math.max(0, col-1); jj< Math.min(M, col+2); jj++)
                        if(!visited[ii][jj] && A[ii][jj]== 1)
                            { q.add(ii); q.add(jj); visited[ii][jj]= true;}
                }
            }
            
            ret= Math.max(ret, ans);
            }
        }
        return ret;
    }
