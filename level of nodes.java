// level of a node
class Level_of_Nodes
{
    
    static int levels(ArrayList<ArrayList<Integer>> list, int curr, int find)
    {
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> set=new HashSet<>(); 
        q.add(curr);
        
        int level=0;
        while(!q.isEmpty())
        {
            int size= q.size();
            
            for(int ii=0;ii<size;ii++)
            {
                curr= q.poll();
                set.add(curr);
                
                if(curr== find)
                    return level;
                
                for(int i: list.get(curr))
                {
                    if(set.contains(i)) continue;
                    
                    q.add(i);
                }
            }
            level++;
        }
        return -1;
    }
}
