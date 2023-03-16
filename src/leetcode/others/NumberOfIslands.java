package leetcode.others;

class UnionFind1 {

    int count;
    int[] parents;
    int[] size;

    public UnionFind1(int count) {
        this.count = count;
        this.parents = new int[count];
        this.size = new int[count];

        for (int i = 0; i < count; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int findRoot(int x) {
        while (x != parents[x]) {
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] > size[rootQ]) {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        this.count --;
    }

    public int getCount() {
        return this.count;
    }

}


public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int countZero = 0;
        int m = grid.length, n = grid[0].length;
        UnionFind1 uf = new UnionFind1(m * n);
        int[][] dirs = new int[][]{{1, 0}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    countZero++;
                    continue;
                }
                for (int[] dir: dirs) {
                    int nxtRow = i + dir[0];
                    int nxtCol = j + dir[1];
                    if (nxtRow < 0 || nxtRow >= m || nxtCol < 0 || nxtCol >= n) {
                        continue;
                    }
                    if (grid[nxtRow][nxtCol] == '1') {
                        uf.union(i*n+j, nxtRow*n+nxtCol);
                    }
                }

            }
        }

        return uf.count - countZero;
    }

}
