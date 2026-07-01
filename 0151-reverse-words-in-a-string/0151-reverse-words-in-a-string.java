class Solution {
    public String reverseWords(String s) {

        StringBuilder ans = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) {
                break;
            }

            int end = i;

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            for (int j = i + 1; j <= end; j++) {
                ans.append(s.charAt(j));
            }

            ans.append(' ');
        }

        ans.deleteCharAt(ans.length() - 1);

        return ans.toString();
    }
}