import java.util.Stack;
class Solution {
    public String removeStars(String s) {

        int n = s.length();
        Stack <Character> stack = new Stack<>();

        for(int i = 0;i<n;i++){

            char ch = s.charAt(i);
            if(ch != '*'){
                stack.push(s.charAt(i));
            }else{
                stack.pop();
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}