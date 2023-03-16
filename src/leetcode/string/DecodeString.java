package leetcode.string;

public class DecodeString {

    private int start = 0;

    private String decodeString(String s, int len) {
        StringBuilder sb = new StringBuilder();
        int multi = 0;
        while (start < len) {
            char c = s.charAt(start);
            start++;
            if (c == '[') {
                String subDecodeStr = decodeString(s, len);
                sb.append(multiplyStr(subDecodeStr, multi));
                multi = 0;
            } else if(c == ']') {
                return sb.toString();
            }else if (isDigital(c)) {
                multi = multi * 10 + (c - '0');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }

    private String multiplyStr(String sb, int multi) {
        if (multi == 0) {
            return sb;
        }
        StringBuilder lastStr = new StringBuilder();
        for (int i = 0; i < multi; i++) {
            lastStr.append(sb);
        }
        return lastStr.toString();
    }


    public String decodeString(String s) {
        int len = s.length();
        return decodeString(s, len);
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        String s = decodeString.decodeString("abc3[cd]xyz");
        System.out.println(s);
    }

}
