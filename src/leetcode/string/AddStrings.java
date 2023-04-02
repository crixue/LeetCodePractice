package leetcode.string;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length(), len2 = num2.length();
        int carry = 0;
        for (int i = len1-1, j = len2-1; i >= 0 || j >= 0; i--, j--) {
            int temp = 0, n1 = 0, n2 = 0;
            if(i >= 0) {
                n1 = num1.charAt(i) - '0';
            }
            if(j >= 0) {
                n2 = num2.charAt(j) - '0';
            }
            temp = n1 + n2 + carry;
            carry = temp / 10;

            sb.append(temp % 10);
        }

        if (carry >0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        String str1 = "9", str2 = "99";
        String s = addStrings.addStrings(str1, str2);
        System.out.println(s);
    }

}
