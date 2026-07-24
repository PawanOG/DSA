import java.util.*;

class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            }
            else if (Character.isLetter(ch)) {
                current.append(ch);
            }
            else if (ch == '[') {
                countStack.push(count);
                stringStack.push(current.toString());

                // Reset for the new substring
                count = 0;
                current = new StringBuilder();
            }
            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());

                while (repeat-- > 0) {
                    temp.append(current);
                }

                current = temp;
            }
        }

        return current.toString();
    }
}