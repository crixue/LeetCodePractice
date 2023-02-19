package leetcode.others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        restore(s, 0, new LinkedList<>());
        return res;
    }

    private boolean strIsValidInAddress(String subStr) {
        if(subStr.length() > 1 && subStr.charAt(0) == '0') return false;
        int n = 0;
        for (char c :
                subStr.toCharArray()) {
            n = n * 10 + (c - '0');
        }
        if(n > 255) return false;
        return true;
    }

    private void restore(String s, int startIndex, LinkedList<String> item) {
        if(startIndex >= s.length()) {
            if(item.size() != 4) return;
            String joinRes = String.join(".", item);
            res.add(joinRes);
            return;
        }

        for (int i = 0; i <= 2; i++) {
            int endIndex = startIndex + i;
            if(endIndex >= s.length()) {
                continue;
            }
            String subStr = s.substring(startIndex, endIndex+1);
            if(!strIsValidInAddress(subStr)) {
                continue;
            }

            item.addLast(subStr);
            restore(s, endIndex+1, item);
            item.removeLast();
        }
    }
}
