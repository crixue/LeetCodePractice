package leetcode.binarySearch;

public class SearchA2dMatrixIi {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (target > matrix[m-1][n-1] || target < matrix[0][0]) {
            return false;
        }

        int i = m-1, j = n-1, left = 0, right = m-1, mid = 0;


        while (i >= 0 || j >= 0) {
            int col = Math.max(j, 0);
            int row = Math.max(i, 0);

            if(matrix[row][col] < target) {
                return false;
            }
            left = 0; right = i; mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                int midVal = matrix[mid][col];
                if(midVal == target) {
                    return true;
                } else if(midVal < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            left = 0; right = j; mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                int midVal = matrix[row][mid];
                if(midVal == target) {
                    return true;
                } else if(midVal < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            i--;
            j--;
        }
        return false;
    }

}
