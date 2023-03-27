package leetcode.string;

public class LongestPalindromicSubstring {

    private int[] longestPalindromeLen(String s, int left, int right) {
        int len = s.length();
        int[] positions = new int[2];
        if(left < 0 || right >= len) {
            return positions;
        }
        for (; left >= 0 && right <= len-1 && s.charAt(left) == s.charAt(right); left--,right++) {
            positions[0] = left;
            positions[1] = right;
        }

        return positions;
    }

    public String longestPalindrome(String s) {
        int len = s.length();

        int[] longestPositions = new int[2];
        for (int i = 0; i < len; i++) {
            //odd
            int[] oddLongestPos = longestPalindromeLen(s, i-1, i+1);
            if (oddLongestPos[1] - oddLongestPos[0] > longestPositions[1] - longestPositions[0]) {
                longestPositions = oddLongestPos;
            }
            //even
            int[] evenLongestPos = longestPalindromeLen(s, i, i+1);
            if (evenLongestPos[1] - evenLongestPos[0] > longestPositions[1] - longestPositions[0]) {
                longestPositions = evenLongestPos;
            }
        }
        return s.substring(longestPositions[0], longestPositions[1]+1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String str = "cbbd";
        String s = longestPalindromicSubstring.longestPalindrome(str);
        System.out.println(s);
    }

}
