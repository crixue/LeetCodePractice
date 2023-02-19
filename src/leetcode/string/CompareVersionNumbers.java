package leetcode.string;

public class CompareVersionNumbers {

    private int transformStr2Int(String str) {
        int n = 0;
        boolean havePrefixZero = false;
        if (str.charAt(0) == '0') {
            havePrefixZero = true;
        } else {
            n = str.charAt(0) - '0';
        }
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '0' && havePrefixZero) {
                continue;
            }
            havePrefixZero = false;
            n = n * 10 + (c - '0');
        }
        return n;
    }

    private int combineVersion(String[] vers, int maxLen) {
        int n = 0;
        for (int i = 0; i < maxLen; i++) {
            if (i < vers.length) {
                n = n * 10 + transformStr2Int(vers[i]);
            } else {
                n = n * 10;
            }
        }
        return n;
    }

    public int compareVersion(String version1, String version2) {
        int len1 = version1.split("\\.").length;
        int len2 = version2.split("\\.").length;

        int maxLen = Math.max(len1, len2);
        int i1 = combineVersion(version1.split("\\."), maxLen);
        int i2 = combineVersion(version2.split("\\."), maxLen);
        if(i1 > i2) {
            return 1;
        } else if (i1 == i2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        int i = compareVersionNumbers.compareVersion("0.1", "1.1");
        System.out.println(i);
    }

}
