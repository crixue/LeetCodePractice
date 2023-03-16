package leetcode.dynamicProgramming;

public class CyclicToOrigin {

    /**
     *
     * @param k  总共k个数字
     * @param n  可以走n步
     */
    public int test(int k, int n) {
        int[][] dp = new int[k+1][n+1];

        dp[0][0] = 1;

        for (int j = 1; j <= n; j++) {
            for(int i = 0; i < k; i++) {
                dp[i][j] = dp[(i+1)%k][j-1] + dp[(i-1+k)%k][j-1];
            }
        }

        return dp[0][n];
    }

    public static void main(String[] args) {
        CyclicToOrigin cyclicToOrigin = new CyclicToOrigin();
        int test = cyclicToOrigin.test(9, 2);
        System.out.println(test);
    }

}
