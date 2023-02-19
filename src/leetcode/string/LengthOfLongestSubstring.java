package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int len  = s.length();

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;
        while (right < len) {
            char rc = s.charAt(right);
            window.put(rc, window.getOrDefault(rc, 0) + 1);

            while (left < right && window.get(rc) > 1) {
                char lc = s.charAt(left);
                window.put(lc, window.get(lc) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

}
