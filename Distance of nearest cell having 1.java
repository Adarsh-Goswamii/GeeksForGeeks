// Distance of nearest cell having 1
class Distance {
    static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        
        Queue<Integer> q=new LinkedList<>();
        boolean[][] seen=new boolean[n][m];
        
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> temp= mat.get(i);
            for(int j=0;j<m;j++)
                if(temp.get(j)==1)
                {
                    q.add(i);
                    q.add(j);
                    seen[i][j]= true;
                }
        }
        
        int level=0;
        
        while(!q.isEmpty())
        {
            int size= q.size();
            
            for(int ii=0;ii<size/2;ii++)
            {
                int x= q.poll();
                int y= q.poll();
                mat.get(x).set(y, level);    
                
                if(x-1>-1 && !seen[x-1][y])
                    { q.add(x-1); q.add(y); seen[x-1][y]= true; }
        
                if(x+1<n && !seen[x+1][y])
                    { q.add(x+1); q.add(y); seen[x+1][y]= true; }
        
                if(y-1>-1 && !seen[x][y-1])
                    { q.add(x); q.add(y-1); seen[x][y-1]= true; }
        
                if(y+1<m && !seen[x][y+1])
                    { q.add(x); q.add(y+1); seen[x][y+1]= true; }
            }
            level++;
        }
        return mat;
    }
}
