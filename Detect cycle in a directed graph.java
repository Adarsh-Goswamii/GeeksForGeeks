// Using DFS
class DetectCycle
{
    static boolean DFSREC(ArrayList<ArrayList<Integer>> adj, boolean[] seen, boolean[] rec, int V, int curr)
    {
        seen[curr]= true;
        rec[curr]= true;
        
        for(int i: adj.get(curr))
        {
            if(!seen[i] && DFSREC(adj, seen, rec, V, i))
                return true;
            
            if(rec[i]) return true;
        }
        rec[curr]= false;
        return false;
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        boolean[] seen=new boolean[V];
        boolean[] rec=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!seen[i])
            if(DFSREC(adj, seen, rec, V, i))
                return true;
        }
        return false;
    }
}
