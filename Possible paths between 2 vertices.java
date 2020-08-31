// Possible paths between 2 vertices
class Path 
{
    static int count=0;
    
    static void DFSREC(ArrayList<ArrayList<Integer>> adj, boolean[] seen, int curr, int destination)
    {
        seen[curr]= true;
        
        for(int i: adj.get(curr))
            DFSREC(adj, seen, i, destination);
        
        if(curr== destination)
            count++;
    }
    
    static int countPaths(ArrayList<ArrayList<Integer>> g, int s, int d) 
    {
        count=0;
        boolean[] seen=new boolean[g.size()];
        
        DFSREC(g, seen, s, d);
        return count;
    }
}
