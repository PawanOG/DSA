class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0
                    && Math.abs(asteroids[i]) > stack.peek()) {
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
                if (stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                }
                // if stack.peek() > abs(asteroids[i]), do nothing
            } else {
                stack.push(asteroids[i]);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            ans[i] = stack.get(i);
        }
        return ans;
    }
}