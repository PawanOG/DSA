class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");

        return check(s,0,s.length()-1); 
    }

    public boolean check(String s,int start,int end){
        if(start>=end){
            return true;
        }
        if(s.charAt(start)!=s.charAt(end)){
            return false;
        }

        return check(s,start+1,end-1);
    }

}