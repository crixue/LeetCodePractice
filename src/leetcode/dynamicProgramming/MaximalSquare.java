package leetcode.dynamicProgramming;

public class MaximalSquare {

    private int maxSideLen = 0;

    private boolean isValidMatrix(char[][] matrix, int startRow, int startCol, int curSideLen) {
        int endRow = startRow + curSideLen - 1;
        int endCol = startCol + curSideLen - 1;

        for (int i = startCol; i <= endCol; i++) {
            if(matrix[startRow][i] != '1') {
                return false;
            }
        }
        for (int i = startRow; i <= endRow; i++) {
            if(matrix[i][endCol] != '1') {
                return false;
            }
        }
        return true;
    }

    private boolean ifCannotExcessMaxSideLen(char[][] matrix, int startRow, int startCol) {
        int m = matrix.length, n = matrix[0].length;

        if(m - startRow <= maxSideLen || n - startCol <= maxSideLen) {
            return  true;
        }
        return false;
    }

    private void dfs(char[][] matrix, int startRow, int startCol, int curSideLen) {
        int m = matrix.length, n = matrix[0].length;

        int endRow = startRow + curSideLen - 1;
        int endCol = startCol + curSideLen - 1;

        if (endRow >= m || endCol >= n || !isValidMatrix(matrix, startRow, startCol, curSideLen)) {
            System.out.println(startRow +"," + startCol+"," +endRow + "," + endCol + "," + curSideLen);
            maxSideLen = Math.max(curSideLen - 1, maxSideLen);
            return;
        }
        dfs(matrix, startRow, startCol, curSideLen + 1);
    }

    public int maximalSquare1(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0' || ifCannotExcessMaxSideLen(matrix, i, j)) {
                    continue;
                }

                dfs(matrix, i, j, 1);
            }
        }
        return maxSideLen * maxSideLen;
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSideLen = Math.max(maxSideLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxSideLen * maxSideLen;
    }

}
