package leetcode.test;

import java.util.*;

public class Test {

    private static final int MAX_NUM = 9;

    private static boolean followRules(char[][] board, int r, int c, char val) {

        for(int i=0; i<MAX_NUM; i++) {
            if(i != c && board[r][i] == val) return false;
            if(i != r && board[i][c] == val) return false;
            if(board[(r/3)*3+i/3][(c/3)*3+i%3] == val) {
                return false;
            }
        }
        return true;
    }

    private static boolean fillSudoku(char[][] board, int r, int c) {
        //base case
        if(r == MAX_NUM-1 && c == MAX_NUM) return true;
        if(c == MAX_NUM) {
            r += 1;
            c = 0;
            return fillSudoku(board, r, c);
        }
        if(board[r][c] != '.') return fillSudoku(board, r, c+1);


        for(char i='1'; i<='9'; i++) {
            if(followRules(board, r, c, i)) {
                board[r][c] = i;
                if(fillSudoku(board, r, c+1)) {
                    return true;
                }
                board[r][c] = '.';
            }
        }
        return false;
    }

    public static boolean isValidSudoku(char[][] board) {
        return fillSudoku(board, 0, 0);
    }


    private static int res = 0;

    private static void backtrace(int m, int n, int[] cur, boolean[][] visited) {
        //base case
        if(cur[0] == m-1 && cur[1] == n-1) {
            res += 1;
            return;
        }

        int[][] dirs = new int[][]{{0,1},{1,0}};
        for(int i=0; i<2; i++) {
            int[] dir = dirs[i];
            int row = cur[0] + dir[0], col = cur[1] + dir[1];
            if(row<0 || row>=m || col<0 || col>=n || visited[row][col]) continue;
            visited[row][col] = true;
            backtrace(m, n, new int[]{row, col}, visited);
            visited[row][col] = false;

        }

    }

    public static int uniquePaths(int m, int n) {
        backtrace(m, n, new int[]{0,0}, new boolean[m][n]);

        return res;
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        if(n <= 2) return dp[n];
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private static List<List<Integer>> res1 = new ArrayList<>();

    private static void backtrace(int[] nums, int start, LinkedList<Integer> item) {
        //base case
        res1.add(new LinkedList<>(item));
        if(start == nums.length) return;

        for(int i=start; i<nums.length; i++) {
            item.add(nums[i]);
            backtrace(nums, i+1, item);
            item.removeLast();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, 0, new LinkedList<Integer>());
        return res1;
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if(heights.length == 1) return heights[0];

        int[] newHeis = new int[heights.length+2];
        newHeis[0] = 0;
        System.arraycopy(heights, 0, newHeis, 1, heights.length);
        newHeis[heights.length+1] = 0;

        int maxArea = 0;
        Deque<Integer> stk = new ArrayDeque<>();
        stk.addLast(0);
        for (int i = 1; i < newHeis.length; i++) {
            while (newHeis[i] < newHeis[stk.peekLast()]) {
                int curHeight = newHeis[stk.pollLast()];
                int curWeight = i - stk.peekLast() - 1;
                maxArea = Math.max(maxArea, curHeight*curWeight);
            }
            stk.add(i);
        }

        return maxArea;
    }

    private static boolean isValidNum(String numStr) {
        if(numStr.length() == 0) return false;
        if(numStr.charAt(0) == '0') return false;
        return Integer.valueOf(numStr) <= 26 && Integer.valueOf(numStr) >= 0;
    }

    private static int res2 = 0;

    private static void backtrace(String s, int index, String lastNum) {
        int sz = s.length();
        //base case
        if(index == sz) {
            res += 1;
            return;
        }

        String curNumStr = s.substring(index, index+1);
        String merged = lastNum + curNumStr;
        if(!curNumStr.equals(merged) && isValidNum(merged)) {
            backtrace(s, index+1, merged);
        }

        if(isValidNum(curNumStr)) {
            backtrace(s, index+1, curNumStr);
        }
    }

    public static int numDecodings(String s) {
        if(s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;

        backtrace(s, 0, "");
        return res;
    }

    public static void main(String[] args) {
        String a = "a";
        String b = new String("a");
        String a1 = "aa";
        String b1 = new String("a") + new String("a");
        System.out.println(a == b);
        System.out.println(a1 == b1);
    }

}
