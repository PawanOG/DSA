class Solution {
    public String removeDuplicateLetters(String s) {

    int[] freq = new int[26];
    boolean[] visited = new boolean[26];

    for(int i=0;i<s.length();i++){
        freq[s.charAt(i)-'a']++;
    }

    Stack <Character> stack = new Stack();
    
    for(int i = 0;i<s.length();i++){

        char ch = s.charAt(i);

        freq[ch-'a']--;

        if(visited[ch-'a']){
            continue;
        }

          while (!stack.isEmpty()
                    && stack.peek() > ch
                    && freq[stack.peek() - 'a'] > 0) {

                visited[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            visited[ch - 'a'] = true;

    }
       StringBuilder ans = new StringBuilder();

        for (char c : stack) {
            ans.append(c);
        }

        return ans.toString();
    }
}