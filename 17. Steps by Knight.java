//17. Steps by Knight

class Solution 
{
    public int minStepToReachTarget(int knightpos[], int targetpos[], int N) 
    {
        Queue<Integer> q=new LinkedList<>();
        boolean[][] visited=new boolean[N][N];
        q.add(knightpos[0]-1);
        q.add(knightpos[1]-1);
        visited[knightpos[0]-1][knightpos[1]-1]= true;
        int step=0;
        
        while(!q.isEmpty())
        {
            int size= q.size();
            
            for(int i=0;i<size/2;i++)
            {
                int row= q.poll();
                int col= q.poll();
                
                if(row== targetpos[0]-1 && col== targetpos[1]-1)
                    return step;
                        
                if(row-1!=-1 && col-2>=0 && !visited[row-1][col-2])
                    { q.add(row-1); q.add(col-2); visited[row-1][col-2]= true; }
                
                if(row-1!=-1 && col+2<N && !visited[row-1][col+2])
                    { q.add(row-1); q.add(col+2); visited[row-1][col+2]= true; }
                    
                if(row+1<N && col-2>=0 && !visited[row+1][col-2])
                    { q.add(row+1); q.add(col-2); visited[row+1][col-2]= true; }
                    
                if(row+1<N && col+2<N && !visited[row+1][col+2])
                    { q.add(row+1); q.add(col+2); visited[row+1][col+2]= true; }
                    
                if(row-2>=0 && col-1>=0 && !visited[row-2][col-1])
                    { q.add(row-2); q.add(col-1); visited[row-2][col-1]= true; }
                    
                if(row-2>=0 && col+1<N && !visited[row-2][col+1])
                    { q.add(row-2); q.add(col+1); visited[row-2][col+1]= true; }
                    
                if(row+2<N && col-1>=0 && !visited[row+2][col-1])
                    { q.add(row+2); q.add(col-1); visited[row+2][col-1]= true; }
                    
                if(row+2<N && col+1<N && !visited[row+2][col+1])
                    { q.add(row+2); q.add(col+1); visited[row+2][col+1]= true; }
            }
            step++;
        }
        return step;
    }
}
