class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer> num = new ArrayList<>();
        int remainder = 0;
        while(n>0 ){
        remainder = n%10;
        n = n/10;
        num.add(remainder);
        }
        Collections.sort(num);
        int size = num.size();
        return num.get(size - 1) * num.get(size - 2);

    }
}