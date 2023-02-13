package leetcode.others;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Uf {
    private int[] parent ;
    private int[] size;
    private int count = 0;

    public Uf(int n) {
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findRoot(int x) {
        while(x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int rootp = findRoot(p);
        int rootq = findRoot(q);
        if(rootp == rootq) return;

        if(size[rootp] > size[rootq]) {
            parent[rootq] = rootp;
            size[rootp] += size[rootq];
        } else {
            parent[rootp] = rootq;
            size[rootq] += size[rootp];
        }

        count--;
    }

    public int count() {
        return this.count;
    }

}

public class UF1NumberOfIslands {

    private static boolean isNeighboar(char[][] grid, int i, int j, int rows, int cols) {
        if(i<0 || i>=rows || j<0 || j>=cols) return false;
        return grid[i][j] == '1';
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(m == 0) return 0;

        Uf uf = new Uf(m*n);
        int[][] directions = new int[][]{{1,0}, {0,1}};
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '0') continue;
                for(int[] dir: directions) {
                    int nxtI = i + dir[0];
                    int nxtJ = j + dir[1];
                    if(!isNeighboar(grid, nxtI, nxtJ, m, n)) continue;
                    uf.union(i*n+j, nxtI*n+nxtJ);
                }
                if(uf.findRoot(i*n+j) == i*n+j) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> inDegreeMemo = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = inDegreeMemo.entrySet();

        char[][] grid = new char[][]{{'1'},{'1'}};
        int i = numIslands(grid);
        System.out.println(i);
    }
}
