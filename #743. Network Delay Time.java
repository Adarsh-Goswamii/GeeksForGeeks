// #743. Network Delay Time


// Dijkstra algorithm: O(n^2+ m) where n is vertex and m is edges. Works fine for a dense graph but can be optimized for sparse one.
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) 
    {
        ArrayList<ArrayList<Integer[]>> arr= new ArrayList<>();
        for(int i=0;i<=N;i++)
            arr.add(new ArrayList<>());
        
        for(int[] time: times)
            arr.get(time[0]).add(new Integer[]{time[1], time[2]});
        
        int[] ans= new int[N+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[K]= 0;
        
        boolean[] visited= new boolean[N+1];
        for(int count=0;count<N;count++)
        {
            int min= Integer.MAX_VALUE, index= -1;
            for(int i=1;i<=N;i++)
            {
                if(ans[i]<min && !visited[i])
                {
                    min= ans[i];
                    index= i;
                }
            }
            if(index== -1) break;
            visited[index]= true;
            
            for(Integer[] i: arr.get(index))
            {
                if(ans[i[0].intValue()]> ans[index]+i[1])
                    ans[i[0].intValue()]= ans[index]+ i[1];
            }
        }
        
        int max= 0;
        for(int i=1;i<ans.length;i++)
            max= Math.max(max, ans[i]);
        
        return max== Integer.MAX_VALUE? -1: max;
    }
}

// Dijkstra Algorithm using priority queue & lazy updation
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) 
    {
        ArrayList<ArrayList<Integer[]>> arr= new ArrayList<>();
        for(int i=0;i<=N;i++)
            arr.add(new ArrayList<>());
        
        for(int[] time: times)
            arr.get(time[0]).add(new Integer[]{time[1], time[2]});
        
        int[] ans= new int[N+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[K]= 0;
        
        PriorityQueue<Integer[]> q= new PriorityQueue<>((a,b) -> (a[1]- b[1]));
        for(int i=1;i<=N;i++)
            q.add(new Integer[]{i, ans[i]});
        
        boolean[] visited= new boolean[N+1];
        for(int count=0;count<N;count++)
        {
            Integer[] index= new Integer[]{-1, 0};
            while(true)
            {
                index= q.poll();
                if(ans[index[0].intValue()]== index[1])
                    break;
            }
            visited[index[0].intValue()]= true;
            
            for(Integer[] i: arr.get(index[0].intValue()))
            {
                if(ans[i[0].intValue()]> ans[index[0].intValue()]+i[1])
                {
                    ans[i[0].intValue()]= ans[index[0].intValue()]+ i[1];
                    q.add(new Integer[]{i[0], ans[i[0].intValue()]});
                }
            }
        }
        
        int max= 0;
        for(int i=1;i<ans.length;i++)
            max= Math.max(max, ans[i]);
        
        return max== Integer.MAX_VALUE? -1: max;
    }
}
