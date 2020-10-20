/*
  Disjoint sets data structure.
  (i). Normal without any optimizations: TLE >3.75sec
  (ii). Union by rank: AC =2.65sec
  (iii). Union by rank and path compression: AC =2.45sec
  */

class UnionFind
{
    public void union(int a, int b, int par[], int rank[])
    {
        while(par[a]!= a)
            a= par[a];
            
        while(par[b]!= b)
            b= par[b];
           
        if(rank[a]> rank[b])
            par[b]= a;
        else if(rank[a]< rank[b])
            par[a]= b;
        else
        { par[b]= a; rank[a]++; }
    }

    public Boolean isConnected(int a, int b, int par[], int rank[])
    {
        while(par[a]!= a)
            a= par[a];
            
        while(par[b]!= b)
            b= par[b];
            
        if(b==a)
            return true;
        else
            return false;
    }
}

// Path compression included.
class UnionFind
{
    public void union(int a, int b, int par[], int rank[])
    {
        while(par[a]!= a)
            a= par[a];
            
        while(par[b]!= b)
            b= par[b];
            
        if(rank[a]> rank[b])
            par[b]= a;
        else if(rank[a]< rank[b])
            par[a]= b;
        else
        { par[b]= a; rank[a]++; }
    }

    public Boolean isConnected(int a, int b, int par[], int rank[])
    {
        int tempA= a, tempB= b;
        while(par[a]!= a)
            a= par[a];
            
        while(par[tempA]!= tempA)
        {
            int temp= tempA;
            tempA= par[tempA];
            par[temp]= a;
        }
            
        while(par[b]!= b)
            b= par[b];
            
        while(par[tempB]!= tempB)
        {
            int temp= tempB;
            tempB= par[tempB];
            par[temp]= b;
        }
            
        if(b==a)
            return true;
        else
            return false;
    }
}
