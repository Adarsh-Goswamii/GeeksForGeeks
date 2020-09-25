// NP-Complete Partition problem
// Using Dynamic Programming- (Bottom up approach)(Tabulation).
// Complexity : O(N*Sum of Elements) both time and space.

class Solution
{
    static int equalPartition(int N, int arr[])
    {
        int sum=0;
        for(int i=0;i<N;i++)
            sum+= arr[i];
            
        boolean[][] tabulation= new boolean[N+1][sum+1];
        for(int i=0;i<=N;i++)
            tabulation[i][0]= true;
            
        for(int i=0;i<=sum;i++)
            tabulation[0][i]= false;
            
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=sum;j++)
                tabulation[i][j]= tabulation[i-1][j] || (j-arr[i-1]>-1?tabulation[i-1][j-arr[i-1]]: false);
        }
        
        if(sum%2==0 && tabulation[N][sum/2])
            return 1;
        else
            return 0; 
    }
}

// Space complexity can be reduced from O(N*sum of elements) to O(sum of elements). As all we need is the last array not the whole matrix.

class Solution
{
    static int equalPartition(int N, int arr[])
    {
        int sum=0;
        for(int i=0;i<N;i++)
            sum+= arr[i];
            
        boolean[] tabulation= new boolean[sum+1];
        tabulation[0]= true;
            
        for(int i=0;i<N;i++)
        {
            boolean[] temp= new boolean[sum+1];
            for(int j=0;j<=sum;j++)
                temp[j]= tabulation[j] || (j-arr[i]>-1?tabulation[j-arr[i]]: false);
                
            tabulation= temp;    
        }
        
        if(sum%2==0 && tabulation[sum/2])
            return 1;
        else
            return 0; 
    }
}
