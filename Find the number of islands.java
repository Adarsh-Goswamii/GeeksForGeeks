
class Islands {
    static void DFSREC(ArrayList<ArrayList<Integer>> adj, boolean[][] seen, int N, int x, int y, int M)
    {
        seen[x][y]= true;
        
        for(int i=Math.max(0, x-1);i<=Math.min(x+1, N-1);i++)
        {
            for(int j=Math.max(0, y-1);j<=Math.min(y+1, M-1);j++)
            {
                if(adj.get(i).get(j)== 1 && !seen[i][j])
                {
                    seen[i][j]= true;
                    DFSREC(adj, seen, N, i, j, M);
                }
            }
        }
    }
    static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) 
    {
        int ans=0;
        boolean[][] seen=new boolean[N][M];
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(!seen[i][j] && A.get(i).get(j)==1)
                {
                    ans++;
                    DFSREC(A, seen, N, i, j, M);
                }
            }
        }
        return ans;
    }
}
