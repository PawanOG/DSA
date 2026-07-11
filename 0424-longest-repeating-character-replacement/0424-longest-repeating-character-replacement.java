class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character,Integer> map = new HashMap<>();
        int maxfreq = 0;
        int size = 0;
        int i = 0;
        int j = 0;
        int maxsize=0;
        while(j<s.length()){
        map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
        maxfreq = Math.max(maxfreq,map.get(s.charAt(j)));
        if((j-i+1)-maxfreq>k){
            char left = s.charAt(i);
            //agar k kam aara h to ham first value of array or left ko hata denge , ham put method usekrte h for this function of removal
            map.put(left,map.get(left)-1);
            i++;
        }
        maxsize = Math.max(maxsize,j-i+1);
        j++;
        }
    return maxsize;
    }
}