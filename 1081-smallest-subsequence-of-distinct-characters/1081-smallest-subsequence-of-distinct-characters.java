class Solution {
    public String smallestSubsequence(String s) {

        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        Stack<Character> stack = new Stack<>();

        for(int i =0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        for(int i = 0;i<s.length();i++){

            char ch = s.charAt(i);

            freq[s.charAt(i)-'a']--;

            if (visited[ch - 'a']) {
                continue;
            }

            while(!stack.isEmpty() &&
                ch<stack.peek() &&
                freq[stack.peek()-'a']>0){
                visited[stack.peek()-'a']=false;
                stack.pop();   
            }

            
            stack.push(ch);
           
            visited[ch-'a']=true;
            

        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}