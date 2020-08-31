// X Total Shapes
static void DFSREC(char[][] arr, boolean[][] seen, int x, int y)
{
    seen[x][y]= true;
    
    if(x-1>-1 && arr[x-1][y]=='X' && !seen[x-1][y])
        DFSREC(arr, seen, x-1, y);
        
    if(x+1<arr.length && arr[x+1][y]=='X' && !seen[x+1][y])
        DFSREC(arr, seen, x+1, y);
        
    if(y-1>-1 && arr[x][y-1]=='X' && !seen[x][y-1])
        DFSREC(arr, seen, x, y-1);
        
    if(y+1<arr[0].length && arr[x][y+1]=='X' && !seen[x][y+1])
        DFSREC(arr, seen, x, y+1);
}

public static int Shape(String []ar,int n,int m)
{
    boolean[][] seen=new boolean[ar.length][ar[0].length()];
    char[][] arr=new char[ar.length][ar[0].length()];
    
    for(int i=0;i<ar.length;i++)
        arr[i]= ar[i].toCharArray();
        
    int ans=0;    
    for(int i=0;i<arr.length;i++)
    {
        for(int j=0;j<arr[i].length;j++)
        {
            if(seen[i][j] || arr[i][j]=='O') continue;
            
            DFSREC(arr, seen, i, j);
            //System.out.println(i+" "+j);
            ans++;
        }
    }
    return ans;
}
