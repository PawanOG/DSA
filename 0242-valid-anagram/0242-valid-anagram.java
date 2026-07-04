class Solution {
    public boolean isAnagram(String s, String t) {

      if(s.length()!=t.length()){
        return false;
        }
        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> tmap = new HashMap<>();
        
        for(int i = 0;i<s.length();i++){

            char char1 = s.charAt(i);
            
            char char2 = t.charAt(i);

            smap.put(char1, smap.getOrDefault(char1,0)+1);
            tmap.put(char2, tmap.getOrDefault(char2,0)+1);

         
        }
        return smap.equals(tmap);

    }
}