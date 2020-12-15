class Solution
{
    static int[] dijkstra(ArrayList<ArrayList<Integer>> g, int src, int V)
    {
        int[] ans= new int[V];
        boolean[] visited= new boolean[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src]= 0;
        
        int count =0;
        while(count!= V){
        int min= Integer.MAX_VALUE, index= -1;
        for(int i=0;i<V;i++)
        {
            if(min>= ans[i] && !visited[i])
            {
                min= ans[i];
                index= i;
            }
        }
        visited[index]= true;
        
        for(int i=0;i<V;i++)
        {
            if(g.get(index).get(i)== 0 || visited[i]) continue;
            if(ans[i]> ans[index]+g.get(index).get(i))
            ans[i]= ans[index]+ g.get(index).get(i);
        }
        count++;
        }
        
        return ans;
    }
}

// as we where already given a adjacency list representation. O(V^2)
