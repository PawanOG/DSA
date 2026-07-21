class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;
        int[][] cars = new int[n][2];

        

        for(int i = 0;i<position.length;i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }

        Arrays.sort(cars,(a,b) -> Integer.compare(a[0],b[0]));

        Stack<Float> stack = new Stack<>();
        float time1 = (float)(target - cars[n - 1][0]) / cars[n - 1][1];

        stack.push(time1);

         for (int i = n - 2; i >= 0; i--) {
            float time2 = (float)(target - cars[i][0]) / cars[i][1];

            if (time2 <= stack.peek()) {
                continue;
            } else {
                stack.push(time2);
            }
        }
        return stack.size();
    }
}