/**
 *  Question demands exhaustive search which will obviously exceed the time limit
 *  1. Normal Recursion (Time Limit Exceeded)
 *  2. Optimization using DP (Memoization). (recursive) (top-down Approach) (0.21 runtime)
 *  3. Optimization using DP (Tabulation). (iterative) (bottom-up Approach) (0.20 runtime)
 */
question link: https://practice.geeksforgeeks.org/problems/longest-common-subsequence/0/
/**********************************************************PLAIN RECURSIVE CODE*************************************************************/
import java.util.*;
import java.io.*;
class LongestCommonSubsequence
{
    InputReader in;
	PrintWriter out;
	int ans;

	void recursion(char[] str1, char[] str2, int index1, int index2, int matched)
    {
        if(index1< str1.length && index2< str2.length)
        {
            if(str1[index1]== str2[index2])
                recursion(str1, str2, index1+1, index2+1, matched+1);
            else
            {
                recursion(str1, str2, index1, index2+1, matched);
                recursion(str1, str2, index1+1, index2, matched);
            }
        }
        else
            ans= Math.max(matched, ans);
    }

    void solve()
    {
        int t= in.nextInt();
        for(int ii=0;ii<t;ii++)
        {
            int len1= in.nextInt(), len2= in.nextInt();

            char[] str1= in.nextLine().toCharArray();
            char[] str2= in.nextLine().toCharArray();
            ans=0;
            recursion(str1, str2, 0, 0, 0);

            out.println(ans);
        }

    }

    void run() throws Exception
	{
		in= new InputReader(System.in);
		out = new PrintWriter(System.out);

		solve();
		out.flush();
	}

	public static void main(String[] args) throws Exception { new LongestCommonSubsequence().run(); }

	static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}

/**************************************************************MEMOIZATION*******************************************************************/
/**
 *  Question demands exhaustive search which will obviously exceed the time limit
 *  1. Normal Recursion (Time Limit Exceeded)
 *  2. Optimization using DP (Memoization). (recursive) (top-down Approach).
 *  3. Optimization using DP (Tabulation). (iterative) (bottom-up Approach).
 */

import java.util.*;
import java.io.*;
class LongestCommonSubsequence
{
    InputReader in;
	PrintWriter out;
	int ans;
	int[][] memoization;
	int recursion(char[] str1, char[] str2, int index1, int index2)
    {
        if(index1< str1.length && index2< str2.length)
        {
            if(memoization[index1][index2]!=-1)
                return memoization[index1][index2];
            else if(str1[index1]== str2[index2])
            {
                memoization[index1][index2]= 1+recursion(str1, str2, index1+1, index2+1);
                return memoization[index1][index2];
            }
            else
            {
                int left= recursion(str1, str2, index1, index2+1);
                int right= recursion(str1, str2, index1+1, index2);
                memoization[index1][index2]= Math.max(left, right);
                return memoization[index1][index2];
            }
        }
        else
            return 0;
    }

    void solve()
    {
        int t= in.nextInt();
        for(int ii=0;ii<t;ii++)
        {
            int len1= in.nextInt(), len2= in.nextInt();

            char[] str1= in.nextLine().toCharArray();
            char[] str2= in.nextLine().toCharArray();
            memoization= new int[len1+1][len2+1];
            for(int i=0;i<len1+1;i++)
                Arrays.fill(memoization[i], -1);
            ans= recursion(str1, str2, 0, 0);

            out.println(ans);
        }

    }

    void run() throws Exception
	{
		in= new InputReader(System.in);
		out = new PrintWriter(System.out);

		solve();
		out.flush();
	}

	public static void main(String[] args) throws Exception { new LongestCommonSubsequence().run(); }

	static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}

/*******************************************************************TABULATION***************************************************************************/

/**
 *  Question demands exhaustive search which will obviously exceed the time limit
 *  1. Normal Recursion (Time Limit Exceeded)
 *  2. Optimization using DP (Memoization). (recursive) (top-down Approach).
 *  3. Optimization using DP (Tabulation). (iterative) (bottom-up Approach).
 */

import java.util.*;
import java.io.*;
class LongestCommonSubsequence
{
    InputReader in;
	PrintWriter out;

    void solve()
    {
        int t= in.nextInt();
        for(int ii=0;ii<t;ii++)
        {
            int len1= in.nextInt(), len2= in.nextInt();

            char[] str1= in.nextLine().toCharArray();
            char[] str2= in.nextLine().toCharArray();
            int[][] tabulation= new int[len1+1][len2+1];

            for(int i=1;i<=len1;i++)
            {
                for(int j=1;j<=len2;j++)
                {
                    if(str1[i-1]== str2[j-1])
                        tabulation[i][j]= tabulation[i-1][j-1] +1;
                    else
                    {
                        tabulation[i][j]= Math.max(tabulation[i-1][j], tabulation[i][j-1]);
                    }
                }
            }

            out.println(tabulation[len1][len2]);
        }
    }

    void run() throws Exception
	{
		in= new InputReader(System.in);
		out = new PrintWriter(System.out);

		solve();
		out.flush();
	}

	public static void main(String[] args) throws Exception { new LongestCommonSubsequence().run(); }

	static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
