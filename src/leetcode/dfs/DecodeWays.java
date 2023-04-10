package leetcode.dfs;

public class DecodeWays {

    private int count = 0;

    private boolean validateDecodeStr(String str) {
        if(str.startsWith("0")) return false;
        Integer value = Integer.valueOf(str);
        return value > 0 && value <= 26;
    }

    private void backtrace(String s, int index) {
        if(index >= s.length()) {
            count++;
            return;
        }

        if (s.charAt(index) != '0') {
            index += 1;
            backtrace(s, index);
            index -= 1;
        }

        if (index + 1 < s.length()) {
            String substring = s.substring(index, index + 2);
            if (!validateDecodeStr(substring)) {
                return;
            }
            index += 2;
            backtrace(s, index);
            index -= 2;
        }
    }

    public int numDecodings(String s) {
        int len = s.length();
        if(s.startsWith("0")) {
            return 0;
        }
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= len; i++) {
            if(s.substring(i-1, i).startsWith("0")) {
                if(validateDecodeStr(s.substring(i-2, i))) {
                    dp[i] = dp[i-2];
                }
                continue;
            }
            if (validateDecodeStr(s.substring(i-2, i))) {
                dp[i] = dp[i-1] + dp[i-2];
                continue;
            }

            dp[i] = dp[i-1];
        }

        return dp[len];
//        backtrace(s, 0);
//        return count;
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("10"));
    }

}
