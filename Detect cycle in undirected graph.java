// Using BFS

class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
       // System.out.println(adj);
        Queue<Integer> q=new LinkedList<>();
        Queue<Integer> parent=new LinkedList<>();
        boolean[] seen=new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(seen[i]) continue;
            
            q.add(i); parent.add(-1); seen[i]= true;
            
            while(!q.isEmpty())
            {
                int size= q.size();
            
                for(int ii=0;ii<size;ii++)
                {
                    int curr= q.poll();
                    int par= parent.poll();
            
                    for(int j: adj.get(curr))
                    {
                        if(j!= par && seen[j])
                            return true;
                        
                        if(j==par) continue;
                        q.add(j);
                        parent.add(curr);
                        seen[j]= true;
                    }
                }
            }
        }
        return false;
    }
}


