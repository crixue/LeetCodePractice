package leetcode.dynamicProgramming;

public class ClimbingStairs {

    public int numWays(int n) {
        int prePreStair = 1, preStair = 2;
        if(n == 0 || n == 1) {
            return prePreStair;
        } else if(n == 2) {
            return preStair;
        }

        for (int i = 3; i <= n; i++) {
            int temp = (prePreStair + preStair) % 1000000007;
            prePreStair = preStair;
            preStair = temp;
        }

        return preStair;
    }

}
