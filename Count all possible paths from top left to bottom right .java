// Count all possible paths from top left to bottom right 
// ques link: https://practice.geeksforgeeks.org/problems/count-all-possible-paths-from-top-left-to-bottom-right/0/?category[]=Dynamic%20Programming&difficulty[]=0&page=2&query=category[]Dynamic%20Programmingdifficulty[]0page2

/**
 *  PROBLEM: 15
 *  Starting in the top left corner of a 2×2 grid, and only being able to move to the right
 *  and down, there are exactly 6 routes to the bottom right corner.
 *  How many such routes are there through a 20×20 grid?
 */

import java.util.*;
class Prob15
{
    static int[][] memo;
    static int DFSREC(int n, int m, int row, int col)
    {
        if(row<=n && col<=m && memo[row][col]!= 0)
            return memo[row][col];
        int right= row+1<=n? DFSREC(n, m, row+1, col): 0;
        int down= col+1<=m? DFSREC(n, m, row, col+1):0;

        memo[row][col]= (right+ down)% 1000000007;
        return memo[row][col];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t= sc.nextInt();
        for(int ii=0;ii<t;ii++)
        {
        int n = sc.nextInt(), m = sc.nextInt();
        memo = new int[n+1][m+1];
        memo[n][m]=1;

        DFSREC(n, m, 1, 1);
        System.out.println(memo[1][1]);
    }}
}

/**
 * OBSERVATIONS: I cant catch any mathematical formula relating size of matrix and route.
 *               Gonna use depth-first-search to calculate it. 
 *
 * OPTIMIZATION: Ok so i will optimize the code using Dynamic programming and for simplicity i will
 *               use memoization over tabulation.
 */
