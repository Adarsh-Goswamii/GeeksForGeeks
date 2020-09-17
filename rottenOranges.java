
// 0: empty; 1: fresh; 2: rotten
class Solution
{
    public int rotOranges(int a[][],int r, int c)
    {
        Queue<Integer> q=new LinkedList<>();
        boolean[][] visited=new boolean[r][c];
        int oranges=0;
        
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                if(a[i][j]==2)
                { q.add(i); q.add(j); visited[i][j]= true; }
                else if(a[i][j]==1)
                    oranges++;
                
                
        int time=0;
        while(!q.isEmpty())
        {
            int size= q.size();
            
            for(int i=0;i<size/2;i++)
            {
                int row= q.poll();
                int col= q.poll();
                
                if(row-1!=-1 && a[row-1][col]==1 && !visited[row-1][col])
                { oranges--; q.add(row-1); q.add(col); visited[row-1][col]= true; }
                
                if(row+1!= r && a[row+1][col]==1 && !visited[row+1][col])
                { oranges--; q.add(row+1); q.add(col); visited[row+1][col]= true; }
                
                if(col-1!=-1 && a[row][col-1]==1 && !visited[row][col-1])
                { oranges--; q.add(row); q.add(col-1); visited[row][col-1]= true; }
                
                if(col+1!= c && a[row][col+1]==1 && !visited[row][col+1])
                { oranges--; q.add(row); q.add(col+1); visited[row][col+1]= true; }
            }
            time++;
        }
        
        if(oranges==0)
            return time-1;
        else
            return -1;
    }
}
