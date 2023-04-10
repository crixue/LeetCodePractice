package leetcode.others;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] curIndex = {0, 0};
        int[] res = new int[m*n];

        int[][] directions = { {-1, 1}, {1, -1} };
        int dirItem = 0 % 2;
        for (int i = 0; i < m * n; i++) {
            res[i] = mat[curIndex[0]][curIndex[1]];
            if(i == m*n-1) break;
            int nxtRow = curIndex[0] + directions[dirItem][0];
            int nxtCol = curIndex[1] + directions[dirItem][1];
//            System.out.println(nxtRow + " " + nxtCol);
            if(nxtRow >= m || nxtCol >= n) {
                if(dirItem == 0) {
                    nxtRow = curIndex[0] + 1;
                    nxtCol = curIndex[1];
                } else {
                    nxtCol = curIndex[1] + 1;
                    nxtRow = curIndex[0];
                }
                dirItem = (dirItem + 1) % 2;
            } else if (nxtRow < 0 || nxtCol < 0) {
                if(dirItem == 0) {
                    nxtCol = curIndex[1] + 1;
                    nxtRow = curIndex[0];
                } else {
                    nxtRow = curIndex[0] + 1;
                    nxtCol = curIndex[1];
                }
                dirItem = (dirItem + 1) % 2;
            }

            curIndex[0] = nxtRow;
            curIndex[1] = nxtCol;
//            System.out.println(curIndex[0] + " " + curIndex[1]);
        }

        return res;
    }

    public static void main(String[] args) {
        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        mat = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        int[] ints = diagonalTraverse.findDiagonalOrder(mat);
        //print int[]
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }


}
