class Solution {
    public int calPoints(String[] operations) {
        int a = 0;
        int b = 0;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("+")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(b + a);
            } else if (operations[i].equals("D")) {
                a = stack.peek();
                stack.push(a * 2);
            } else if (operations[i].equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(operations[i]));
            }

        }
        
        while(!stack.isEmpty()){
           result = result + stack.pop();
        }
        return result;
    }
}