package leetcode.others;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    private static List<Integer> res;

    private void dfs(int[][] matrix, int i, int j, boolean[][] visited, int directionIndex) {
        int m = matrix.length, n = matrix[0].length;

        if (res.size() == m * n) {
            return;
        }

        int[][] directions = new int[][]{{0, 1}, {1, 0},  {0, -1}, {-1, 0}};

        visited[i][j] = true;
        res.add(matrix[i][j]);

        int nxtRow = i + directions[directionIndex][0];
        int nxtCol = j + directions[directionIndex][1];
        if(nxtRow < 0 || nxtRow >= m || nxtCol < 0 || nxtCol >= n || visited[nxtRow][nxtCol]) {
            directionIndex = (directionIndex + 1) % 4;
            nxtRow = i + directions[directionIndex][0];
            nxtCol = j + directions[directionIndex][1];
        }
        dfs(matrix, nxtRow, nxtCol, visited, directionIndex);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        res = new ArrayList<>();

        dfs(matrix, 0, 0, visited, 0);
        return res;
    }

}
