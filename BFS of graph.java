class Traversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) 
    {
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        boolean[] visited=new boolean[N];
        q.add(0);
        visited[0]= true;
        
        while(!q.isEmpty())
        {
            int size= q.size();
            
            for(int ii=0;ii<size;ii++)
            {
                int curr= q.poll();
                ans.add(curr);
                List<Integer> temp= g.get(curr);
                
                for(int i=0;i<temp.size();i++)
                {
                    if(visited[temp.get(i)]) continue;
                    q.add(temp.get(i));
                    visited[temp.get(i)]= true;
                }
            }
        }
        
        return ans;
    }
}
