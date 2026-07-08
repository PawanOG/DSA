class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> substring = new HashSet<>();
        char[] arr = s.toCharArray();
        int j = 0;
        int maxlength = 0;
        for(int i=0;i<arr.length;i++){
            while(substring.contains(arr[i])){ 
            substring.remove(arr[j]);
            j++;
           }

           substring.add(arr[i]);
           maxlength = Math.max(maxlength,substring.size());


        }
        return maxlength;
    }

}