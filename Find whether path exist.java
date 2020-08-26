// Depth First search based algo
class Solution
{
    static boolean DFSREC(int[][] arr, boolean[][] seen, int n, int x, int y)
    {
        seen[x][y]= true;
        boolean ret= false;
        
        if(x-1>-1 && !seen[x-1][y])
        {
            if(arr[x-1][y]==2)
                return true;
            else if(arr[x-1][y]== 3)
                ret= ret || DFSREC(arr, seen, n, x-1, y);
        }

        if(x+1<n && !seen[x+1][y])
        {
            if(arr[x+1][y]==2)
                return true;
            else if(arr[x+1][y]== 3)
                ret= ret || DFSREC(arr, seen, n, x+1, y);
        }

        if(y-1>-1 && !seen[x][y-1])
        {
            if(arr[x][y-1]==2)
                return true;
            else if(arr[x][y-1]== 3)
                ret= ret || DFSREC(arr, seen, n, x, y-1);
        }

        if(y+1<n && !seen[x][y+1])
        {
            if(arr[x][y+1]==2)
                return true;
            else if(arr[x][y+1]== 3)
                ret= ret || DFSREC(arr, seen, n, x, y+1);
        }
        return ret;
    }
    public static int is_possible(int arr[][], int N)
    {
        int i=0, j=0;
        boolean[][] seen= new boolean[arr.length][arr[0].length];
        outer: for(i=0;i<arr.length;i++)
            for(j=0;j<arr[0].length;j++)
                if(arr[i][j]==1)
                    break outer;

        if(DFSREC(arr, seen, N, i, j))
            return 1;
        else
            return 0;
    }
}

// Breadth first search based algo
class Solution
{
    public static int is_possible(int arr[][], int n)
    {
        Queue<Integer> q=new LinkedList<>();
        boolean[][] seen=new boolean[arr.length][arr[0].length];
        int i=0, j=0;

        outer: for(i=0;i<arr.length;i++)
        {
            for(j=0;j<arr[0].length;j++)
                if(arr[i][j]== 1)
                    break outer;
        }

        q.add(i); q.add(j);

        while(!q.isEmpty())
        {
            int size= q.size();

            for(i=0;i<size/2;i++)
            {
                int x= q.poll();
                int y= q.poll();
                seen[x][y]= true;
                
                if(x-1>-1 && !seen[x-1][y])
                {
                    if(arr[x-1][y]==2)
                        return 1;
                    else if(arr[x-1][y]== 3)
                    {
                        seen[x-1][y]= true;
                        q.add(x-1); q.add(y);
                    }
                }

                if(x+1<n && !seen[x+1][y])
                {
                    if(arr[x+1][y]==2)
                        return 1;
                    else if(arr[x+1][y]== 3)
                    {
                        seen[x+1][y]= true;
                        q.add(x+1); q.add(y);
                    }
                }

                if(y-1>-1 && !seen[x][y-1])
                {
                    if(arr[x][y-1]==2)
                        return 1;
                    else if(arr[x][y-1]== 3)
                    {
                        seen[x][y-1]= true;
                        q.add(x); q.add(y-1);
                    }
                }

                if(y+1<n && !seen[x][y+1])
                {
                    if(arr[x][y+1]==2)
                        return 1;
                    else if(arr[x][y+1]== 3)
                    {
                        seen[x][y+1]= true;
                        q.add(x); q.add(y+1);
                    }
                }
            }
        }
        return 0;
    }
}
