import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        if (m > n) return false;

        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        String sortedS1 = new String(arr1);

        for (int i = 0; i <= n - m; i++) {

            String sub = s2.substring(i, i + m);

            char[] arr2 = sub.toCharArray();
            Arrays.sort(arr2);

            if (sortedS1.equals(new String(arr2))) {
                return true;
            }
        }

        return false;
    }
}