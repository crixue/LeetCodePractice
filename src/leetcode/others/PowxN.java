package leetcode.others;

public class PowxN {

    private double calculatePow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        if((n & 1) == 1) {
            double subRes = calculatePow(x, n / 2);
            return x * subRes * subRes;
        }

        double subRes = calculatePow(x, n / 2);
        return subRes * subRes;
    }


    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if(n < 0) {
            return 1 / calculatePow(x, -n);
        }
        return calculatePow(x, n);
    }

    public static void main(String[] args) {
        PowxN powxN = new PowxN();
        System.out.println(powxN.myPow(2, 10));
    }

}
