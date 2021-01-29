


private int primeFactorization(long n) 
    {
        HashMap<Long, Integer> map= new HashMap<>();
        int ret= 0;
        while(n%2== 0)
        {
            map.put(2l, map.getOrDefault(2l, 0)+1);
            n>>=1;
            ret++;
        }

        for(long i= 3;i<=Math.sqrt(n);i+=2)
        {
            while(n%i== 0)
            {
                map.put(i, map.getOrDefault(i, 0)+1);
                n/= i;
                ret++;
            }
        }

        if(n>2)
        {
            ret++;
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        return ret;
    }
