
class Traversal
{
    static ArrayList<Integer> ans;
    static void DFSREC(ArrayList<ArrayList<Integer>> adj, boolean[] seen, int n, int curr)
    {
        ans.add(curr);
        seen[curr]= true;
        
        for(int i: adj.get(curr))
        {
            if(seen[i]) continue;
            
            seen[i]= true;
            DFSREC(adj, seen, n, i);
        }
        
    }
    
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
        boolean seen[]=new boolean[N];
        ans=new ArrayList<Integer>();
       for(int i=0;i<N;i++)
        if(!seen[i])
            DFSREC(g, seen,  N, i);
        return ans;
    }
}
