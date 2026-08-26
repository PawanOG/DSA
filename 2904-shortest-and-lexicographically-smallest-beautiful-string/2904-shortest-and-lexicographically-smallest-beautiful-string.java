class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
           
           int n = s.length();
           String ans = "";
           
           for(int i = 0;i<n;i++){
                
                int onecnt = 0;
                String curr = "";
                
                for(int j = i;j<n;j++){
                    curr = curr + s.charAt(j);

                    if(s.charAt(j)=='1'){
                        onecnt++;
                    }

                    if(onecnt>k){
                        break;
                    }

                    if(onecnt == k){
                        if(ans.isEmpty() || curr.length() < ans.length() || (curr.length() == ans.length() && curr.compareTo(ans) < 0)){
                            ans = curr;
                        }
                    }
                }
           }
           return ans;
    }
}