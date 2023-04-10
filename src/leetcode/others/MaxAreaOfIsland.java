package leetcode.others;


class UnionFindMaxAreaOfIsland {

    private int[] parent;
    private int[] size;
    private int maxSize;
    private int count;

    public UnionFindMaxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        this.parent = new int[m*n];
        this.size = new int[m*n];
        this.maxSize = 0;
        this.count = m*n;
        for (int i = 0; i < m * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findRoot(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        if(rootP == rootQ) {
            return;
        }
        System.out.println(p + " union " + q);
        if (size[rootP] >= size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] = size[rootQ] + size[rootP];
            maxSize = Math.max(maxSize, size[rootP]);
        } else {
            parent[rootP] = rootQ;
            size[rootQ] = size[rootQ] + size[rootP];
            maxSize = Math.max(maxSize, size[rootQ]);
        }
        count--;
    }

    public int getMaxSize() {
        return maxSize;
    }
}

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{1,0}, {0,1}};

        UnionFindMaxAreaOfIsland uf = new UnionFindMaxAreaOfIsland(grid);
        int existsOne = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0) continue;
                existsOne = 1;
                for (int[] dir: directions) {
                    int nxtRow = i + dir[0];
                    int nxtCol = j + dir[1];
                    if (nxtRow >= m || nxtCol >= n) continue;
                    if(grid[nxtRow][nxtCol] == 1) {
//                        System.out.println(i + ":" + j + " union " + nxtRow+ ":" + nxtCol);
                        uf.union(i*n+j, nxtRow*n+nxtCol);
                    }
                }
            }
        }

        return Math.max(uf.getMaxSize(), existsOne);
    }

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int[][] grid = new int[][]{{1,1,0,0,0}, {1,1,0,0,0}, {0,0,0,1,1}, {0,0,0,1,1}};
        int i = maxAreaOfIsland.maxAreaOfIsland(grid);
        System.out.println(i);
    }
}
