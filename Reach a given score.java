

import java.util.Scanner;

class ReachAGivenScore
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();

        for(int ii=0;ii<t;ii++)
        {
            int n= sc.nextInt();
            int[] arr={3, 5, 10};
            int[] tabulation= new int[n+1];
            tabulation[0]= 1;

            for(int i: arr)
            {
                for(int j=i;j<=n;j++)
                    tabulation[j]+= tabulation[j-i];
            }

            System.out.println(tabulation[n]);
        }
    }
}
