// Minimum Spanning Tree - Prim's Algorithm
// Normal: adjacency matrix.
// Optimisation: adjacency list+ heap.

// IDEA: we can use a min heap that stores all the vertex that are not included so every time we will just have to pop the root element (work which Loop 1 is assigned).
//       So the complexity will reduce from O(V) to O(log v) for that particular loop.

class MST {
    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph) 
    {
        int[] key= new int[V];
        boolean[] mset=new boolean[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0]=0;
        int ans=0;
        
        for(int i=0;i<V;i++)
        {
            int u=-1;
            // This loop is to search for an element that is not already included in the mset and has the minimum key[] value among them.
            // u is automatically assigned to the first element thats not included as u initial value -1 works as an flag.
            for(int j=0;j<V;j++)
            {
                if(!mset[j] && (u==-1 || key[j]< key[u]))
                    u= j;
            }
            mset[u]= true;
            ans+= key[u];
            
            // Now when we have a vertex which is not included in the mset and has tha lowest key[] value, we update the key[] array.
            // Updation is done only for elements that are not included and have key[] value greater than that from u.
            // In terms of graph you can understand it like this, key[] array holds the min weight to get to a vertex and we update that array we check if there is 
            // an edge from the selected vertex to a particular vertex whose weight is less than which is already in key[].
            for(int j=0;j<V;j++)
            {
                if(!mset[j] && graph.get(u).get(j)< key[j])
                    key[j]= graph.get(u).get(j);
            }
        }
        return ans;
    }
}
