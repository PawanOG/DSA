class Solution {
    public String removeDuplicates(String s) {

        int n = s.length();
        Stack <Character> stack = new Stack<>();

        for(int i = 0;i<n;i++){
            if(!stack.isEmpty() && stack.peek()==s.charAt(i)){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();

        for(char ch : stack){
            ans.append(ch);
        }
        return ans.toString();
    }
}