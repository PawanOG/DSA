

class Solution {
    public int smallestNumber(int n, int t) {

        for (int i = n; i <= 100; i++) {
            if (digitsmultiple(i) % t == 0) {
                return i;
            }
        }
        return -1;
    }

    public int digitsmultiple(int n) {
        int digitmult = 1;

        while (n > 0) {
            int rem = n % 10;
            digitmult *= rem;
            n /= 10;
        }

        return digitmult;
    }
}