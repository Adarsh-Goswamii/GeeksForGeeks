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
