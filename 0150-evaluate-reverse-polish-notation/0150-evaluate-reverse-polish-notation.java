class Solution {
    public int evalRPN(String[] tokens) {
        int a = 0;
        int b = 0;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
               a = stack.pop();
               b = stack.pop();
               stack.push(b+a);
            }
            else if(tokens[i].equals("-")){
               a = stack.pop();
               b = stack.pop();
               stack.push(b-a);
            }
            else if(tokens[i].equals("*")){
               a = stack.pop();
               b = stack.pop();
               stack.push(b*a);
            }
            else if(tokens[i].equals("/")){
               a = stack.pop();
               b = stack.pop();
               stack.push(b/a);
            }else{
            stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}