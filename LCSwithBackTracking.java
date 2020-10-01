
import java.util.*;
class LCS
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int len1= sc.nextInt();
        int len2= sc.nextInt();
        int[] arr= new int[len1];
        int[] arr2= new int[len2];
        for(int i=0;i<len1;i++)
            arr[i]= sc.nextInt();

        for(int i=0;i<len2;i++)
            arr2[i]= sc.nextInt();

        int[][][] tabulation= new int[len1+1][len2+1][2];
        // -1= UP
        // -2= LEFT
        // -3= UP then LEFT

        for(int i=1;i<=len1;i++)
        {
            for(int j=1;j<=len2;j++)
            {
                if(arr[i-1]== arr2[j-1])
                    tabulation[i][j]= new int[]{tabulation[i-1][j-1][0]+1,-3};
                else
                {
                    if(tabulation[i-1][j][0]> tabulation[i][j-1][0])
                        tabulation[i][j]= new int[]{tabulation[i-1][j][0], -1};
                    else
                        tabulation[i][j]= new int[]{tabulation[i][j-1][0], -2};
                }
            }
        }

        int i=len1, j=len2;
        int[] ans= new int[tabulation[len1][len2][0]];
        int index= ans.length;

        while(i!=0 && j!=0)
        {
            if(tabulation[i][j][1]== -3)
            {
                ans[--index]= arr[i-1];
                i--;
                j--;
            }
            else if(tabulation[i][j][1]== -1)
                i--;
            else
                j--;
        }

        for(i=0;i<ans.length;i++)
            System.out.print(ans[i]+" ");
        System.out.println();
    }
}
