package leetcode.test;

import leetcode.tree.git.TreeNode;

import java.util.*;

public class Test1 {

    private static boolean backtrace(char[][] board, int r, int c, String word, int wordIndex, boolean[][] visited) {
        // base case
        int row = board.length, col = board[0].length;

        if(!word.substring(wordIndex, wordIndex+1).equals(String.valueOf(board[r][c]))) {
            return false;
        }
        if(word.length()-1 == wordIndex) {
            return true;
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i=0; i<directions.length; i++) {
            int nxtRow = r+directions[i][0], nxtCol = c+directions[i][1];
            if(nxtRow<0 || nxtRow>=row || nxtCol<0 || nxtCol>=col || visited[nxtRow][nxtCol]) {
                continue;
            }
            visited[nxtRow][nxtCol] = true;
            if(backtrace(board, nxtRow, nxtCol, word, wordIndex+1, visited)) {
                return true;
            }
            visited[nxtRow][nxtCol] = false;
        }
        return false;
    }

    public static boolean exist(char[][] board, String word) {
        if(word.length() == 0) return false;

        char fst = word.charAt(0);
        int row = board.length, col = board[0].length;
        Map<Character, Integer> boardMemo = new HashMap<>();
        List<int[]> fstPos = new ArrayList<>();

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                char c = board[i][j];
                if(c == fst) fstPos.add(new int[]{i, j});
                boardMemo.put(c, boardMemo.getOrDefault(c, 0)+1);
            }
        }

        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!boardMemo.containsKey(c)) return false;
            boardMemo.put(c, boardMemo.get(c)-1);
            if(boardMemo.get(c) < 0) return false;
        }

        if(word.length() == 1) return true;

        boolean[][] visited = new boolean[row][col];
        for(int[] pos: fstPos) {
            if(backtrace(board, pos[0], pos[1], word, 0, visited)) return true;
        }

        return false;
    }


    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }


    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;

        System.out.println(Integer.MAX_VALUE == i);

    }

}
