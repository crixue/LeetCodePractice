package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    private boolean needShrink(Map<Character, Integer> need, Map<Character, Integer> window) {
        if (need.size() > window.size()) {
            return false;
        }

        for(Character c: need.keySet()) {
            if(window.get(c) < need.get(c)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        String minStr = "";
        while (right < m) {
            char cr = s.charAt(right);
            if (need.containsKey(cr)) {
                window.put(cr, window.getOrDefault(cr, 0) + 1);
            }

            while (left <= right && needShrink(need, window)) {
                char cl = s.charAt(left);
                if (!need.containsKey(cl)) {
                    left ++;
                    continue;
                }
                int mins = window.get(cl) - 1;
                if (mins <= 0) {
                    window.remove(cl);
                } else {
                    window.put(cl, mins);
                }
                if(window.getOrDefault(cl, 0) < need.get(cl)) {
                    String subStr = s.substring(left, right + 1);
                    if (minStr.equals("") || subStr.length() < minStr.length()) {
                        minStr = subStr;
                    }
                    left ++;
                    break;
                }
                left ++;
            }

            right ++;
        }
        return minStr;
    }

}
