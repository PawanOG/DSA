class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check if palindrome is possible
        int oddCount = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                oddCount++;
                middle = i;
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int halfLen = n / 2;

        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        String best = null;

        /*
         * Try making the LEFT HALF greater than target's
         * left half.
         */
        for (int change = halfLen - 1; change >= 0; change--) {

            int[] remaining = halfFreq.clone();
            char[] half = new char[halfLen];

            boolean possible = true;

            // Copy prefix equal to target
            for (int i = 0; i < change; i++) {

                int c = target.charAt(i) - 'a';

                if (remaining[c] == 0) {
                    possible = false;
                    break;
                }

                half[i] = target.charAt(i);
                remaining[c]--;
            }

            if (!possible) {
                continue;
            }

            // Choose smallest character greater than target[change]
            int targetChar = target.charAt(change) - 'a';

            int chosen = -1;

            for (int c = targetChar + 1; c < 26; c++) {
                if (remaining[c] > 0) {
                    chosen = c;
                    break;
                }
            }

            if (chosen == -1) {
                continue;
            }

            half[change] = (char) ('a' + chosen);
            remaining[chosen]--;

            // Fill remaining half with smallest characters
            int pos = change + 1;

            for (int c = 0; c < 26; c++) {
                while (remaining[c] > 0) {
                    half[pos++] = (char) ('a' + c);
                    remaining[c]--;
                }
            }

            String candidate = buildPalindrome(half, middle, n);

            if (candidate.compareTo(target) > 0) {

                if (best == null ||
                    candidate.compareTo(best) < 0) {

                    best = candidate;
                }
            }
        }

        /*
         * Also try making the LEFT HALF exactly equal to
         * target's left half.
         *
         * This is crucial for:
         *
         * s = "aabb"
         * target = "abaa"
         *
         * half = "ab"
         * palindrome = "abba"
         */
        int[] remaining = halfFreq.clone();
        char[] half = new char[halfLen];

        boolean possible = true;

        for (int i = 0; i < halfLen; i++) {

            int c = target.charAt(i) - 'a';

            if (remaining[c] == 0) {
                possible = false;
                break;
            }

            half[i] = target.charAt(i);
            remaining[c]--;
        }

        if (possible) {

            String candidate = buildPalindrome(half, middle, n);

            if (candidate.compareTo(target) > 0) {

                if (best == null ||
                    candidate.compareTo(best) < 0) {

                    best = candidate;
                }
            }
        }

        return best == null ? "" : best;
    }

    private String buildPalindrome(char[] half, int middle, int n) {

        StringBuilder sb = new StringBuilder();

        // Left half
        for (char c : half) {
            sb.append(c);
        }

        // Middle character
        if (n % 2 == 1) {
            sb.append((char) ('a' + middle));
        }

        // Right half
        for (int i = half.length - 1; i >= 0; i--) {
            sb.append(half[i]);
        }

        return sb.toString();
    }
}