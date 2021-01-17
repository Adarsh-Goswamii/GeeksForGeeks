/*

to find one of the +ive values of (x, y) that satisfies the eq:
        ax+ by= c;
        a, b, c are given.
        
*/

    void solve() throws IOException {
        int c= ni(), a= ni(), b= ni();

        long x= 1, y= 0;
        long xt= 0, yt= 1, at= a, bt= b;
        while(bt!=0)
        {
            long q= at/ bt;

            long temp= xt;
            xt= x- q*xt;
            x= temp;

            temp= yt;
            yt= y- q*yt;
            y= temp;

            temp= bt;
            bt= at- q*bt;
            at= temp;
        }

        if(c% at!=0)
        {
            out.println("NO");
            return;
        }

        x= x* (c/ at);
        y= y* (c/ at);
//        out.println(x+" "+y);

        if(x>=0 && y>=0)
            out.println("YES\n"+x+" "+y);
        else if(x<0 && y<0)
            out.println("NO");
        else if(x>=0 && y<0)
        {
            long k= (y*at/a);
            x= x+ k*(b/at);
            y= y- k*(a/at);
//            out.println(x+" "+y);

            while(true)
            {
                if(x<0) {
                    out.println("NO");
                    break;
                }
                else if(x>=0 && y>=0) {
                    out.println("YES\n"+x+" "+y);
                    break;
                }

                x= x- (b/at);
                y= y+ (a/at);
            }
        }
        else
        {
            long k= x*at/b;
            x= x+ (k*(b/at));
            y= y- (k*(a/at));

            while(true)
            {
                if(y<0) {
                    out.println("NO");
                    break;
                }
                else if(x>=0 && y>=0) {
                    out.println("YES\n"+x+" "+y);
                    break;
                }

                x= x+ (b/at);
                y= y- (a/at);

            }
        }
    }
