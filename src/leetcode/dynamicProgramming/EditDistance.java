package leetcode.dynamicProgramming;

public class EditDistance {

    private int min3(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();

        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int minLastOper = min3(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]);
                    dp[i][j] = minLastOper + 1;
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        EditDistance editDistance = new EditDistance();
        int i = editDistance.minDistance(word1, word2);
        System.out.println(i);
    }

}
