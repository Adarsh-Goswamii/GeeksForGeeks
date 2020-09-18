
class GfG 
{
	public int minSwaps(int[] arr, int N) 
	{
	    boolean[] visited=new boolean[N];
	    int[] copy=new int[N];
	    HashMap<Integer, Integer> map=new HashMap<>();
	    
	    for(int i=0;i<N;i++)
	        copy[i]= arr[i];
	    Arrays.sort(copy);
	    
	    for(int i=0;i<N;i++)
	        map.put(copy[i], i);
	        
	    int ans=0;
	    
	    for(int i=0;i<N;i++)
	    {
	        int edge= 0, curr= i;
	        while(!visited[curr])
	        {
	            visited[curr]= true;
	            curr= map.get(arr[curr]);
	            edge++;
	        }
	        ans+= edge==0? 0: edge-1;
	    }
	    return ans;
	}
}
