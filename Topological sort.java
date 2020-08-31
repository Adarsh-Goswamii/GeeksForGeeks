// Topological sort (BFS)
class TopologicalSort {
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int n)
    {
        int[] indegree=new int[n];
        int[] ans=new int[n];

        for(int i=0;i<adj.size();i++)
        {
            for(int j: adj.get(i))
                indegree[j]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
            if(indegree[i]==0) q.add(i);

        int c=0;
        while(!q.isEmpty())
        {
            int size= q.size();

            for(int i=0;i<size;i++)
            {
                int curr= q.poll();
                ans[c++]= curr;
                
                for(int j: adj.get(curr))
                {
                    indegree[j]--;
                    
                    if(indegree[j]==0)
                        q.add(j);
                }
            }
        }
        return ans;
    }
}

// Topological sort (DFS) 
class TopologicalSort 
{
    static Stack<Integer> stack;
    
    static void DFSREC(ArrayList<ArrayList<Integer>> adj, boolean[] seen, int curr)
    {
        seen[curr]= true;
        
        for(int i: adj.get(curr))
        {
            if(seen[i]) continue;
            
            seen[i]= true;
            DFSREC(adj, seen, i);
        }
        stack.push(curr);
    }
    
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) 
    {
        boolean[] seen= new boolean[N];
        stack= new Stack<Integer>();
        
        for(int i=0;i<N;i++)
        {
            if(!seen[i])
                DFSREC(adj, seen, i);
        }
        
        int[] ans=new int[N];
        int c=0;
        
        while(!stack.isEmpty())
            ans[c++]= stack.pop();
        
        return ans;
    }
}
