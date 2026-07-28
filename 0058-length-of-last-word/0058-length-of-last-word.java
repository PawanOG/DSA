class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        int start = 0;
        int count = 0;

        while (end >= 0) {                
            if (s.charAt(end) == ' ') {    // corrected: '' -> ' '
                end--;
            } else {
                while (end >= 0 && s.charAt(end) != ' ') { 
                    count++;
                    end--;                
                }
            break;
            }
        }
        return count;
    }
}