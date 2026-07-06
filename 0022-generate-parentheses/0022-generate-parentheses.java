class Solution {
    public List<String> generateParenthesis(int n) {
        int open = 0;
        int close = 0;
        String curr = "";
        ArrayList<String> ans = new ArrayList<>();
         
        helper(curr,n,open,close,ans);
        return ans;
         
    }
    public static void helper(String curr,int n,int open,int close,ArrayList<String> ans){

        if(curr.length()==2*n){
            ans.add(curr);
            return;
        }
        if(open<n){
            helper(curr + "(",n,open+1,close,ans);
        }
        if(close<open){
            helper(curr + ")",n,open,close+1,ans);
        }
        
    }
}