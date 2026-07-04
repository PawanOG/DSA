class Solution {
    public int myAtoi(String s) {

        s = s.trim();

        if (s.length() == 0) {
            return 0;
        }

        int sign = 1;
        int i = 0;
        long num = 0;
        int n = s.length();

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {

            num = num * 10 + (s.charAt(i) - '0');

            if (sign == 1 && num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign == -1 && -num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (sign * num);
    }
}