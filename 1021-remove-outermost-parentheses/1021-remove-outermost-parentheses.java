class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length()-1;
        int count = 0;
        StringBuilder ans = new StringBuilder();

        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==')'){
                count--;
            }

            if(count!=0){
                ans.append(s.charAt(i));
            }

            if(s.charAt(i)=='('){
                count++;
            }
        }
        return ans.toString();
        
    }
}