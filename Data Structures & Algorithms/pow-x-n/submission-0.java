class Solution {
    public double myPow(double x, int n) {
        double val = pow(x, n);        
        if(n < 0) {
            return 1 / val;
        }

        return val;
    }

    private double pow(double x, int n) {
        if(n == 0) {
            return 1;
        }

        if(n == 1) {
            return x;
        }

        double cal = pow(x, n/2);
        
            if ( n % 2 == 0) {
                return cal * cal;
            } else {
                return cal * cal * x;
            }
        
    }
}
