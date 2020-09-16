// kosaraju's algorithm for finding strongly connected components. (DFS based algorithm)

class Solution
{
    static void DFSREC(ArrayList<ArrayList<Integer>> g, int index, boolean[] visited, Stack<Integer> stack)
    {
        visited[index]= true;
        
        for(int i: g.get(index))
        {
            if(!visited[i])
                DFSREC(g, i, visited, stack);
        }
        
        stack.push(index);
    }
    
    static int findMother(ArrayList<ArrayList<Integer>> g, int n)
    {
        Stack<Integer> stack=new Stack<>();
        boolean[] visited= new boolean[n];
        
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
                DFSREC(g, i, visited ,stack);
        }
        
        int mother= stack.pop();
        visited= new boolean[n];
        stack= new Stack<Integer>();
        
        DFSREC(g, mother, visited, stack);
        if(stack.size()==n)
            return mother;
        else
            return -1;
    }
}
