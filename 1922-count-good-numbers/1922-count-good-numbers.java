class Solution {

    long mod = 1000000007;

    public int countGoodNumbers(long n) {

        long even = (n + 1) / 2;
        long odd = n / 2;

        return (int)((pow(5, even) * pow(4, odd)) % mod);
    }

    public long pow(long base, long exp) {

        long ans = 1;

        while (exp > 0) {

            if (exp % 2 == 1) {
                ans = (ans * base) % mod;
            }

            base = (base * base) % mod;
            exp /= 2;
        }

        return ans;
    }
}