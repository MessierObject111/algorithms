package com.companies.meta;
//50. Pow(x, n)
public class QuickPow {
    //Brute force O(N): Time Limit Exceeded
    public double myPowBruteForce(double x, int n) {
        if(x == 1) return x;
        double base = x;
        if(n > 0) {
            while(n > 1) {
                x = x*base;
                n--;
            }
        } else {
            while(n <= 0) {
                x = x/base;
                n++;
            }
        }
        return x;
    }

    //Recersive logarithmic alghorithm: O(log(N)):
    public double myPow(double x, int n) {
        if(x == 1) return x;
        if(n == 0) return 1.0;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return quickPow(x, N);
    }

    private double quickPow(double x, long n) {
        System.out.println("x:" + x + " n:" + n);
        if(n == 1) return x;
        // if (n == 0) {
        //     return 1.0;
        // }
        //When n is odd number, n/2 will lose 1, e.g. 5/2 = 2. To compensate, we need to * x
        double half = quickPow(x, n/2);
        System.out.println("half:" + half);
        if(n % 2 != 0) {
            return half * half * x;
        }
        return half * half;
    }
}
