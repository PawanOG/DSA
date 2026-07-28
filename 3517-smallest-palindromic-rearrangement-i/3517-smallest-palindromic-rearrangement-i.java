import java.util.Arrays;

class Solution {
    public String smallestPalindrome(String s) {

        int n = s.length();

        char[] left = s.substring(0, n / 2).toCharArray();
        Arrays.sort(left);

        StringBuilder ans = new StringBuilder();

        ans.append(left);

        if (n % 2 == 1) {
            ans.append(s.charAt(n / 2));
        }

        for (int i = left.length - 1; i >= 0; i--) {
            ans.append(left[i]);
        }

        return ans.toString();
    }
}