class Solution {
    public boolean checkDivisibility(int n) {
        int s = product(n)+sum(n);
        if(n%s==0){
            return true;
        }else return false;
    }

    public int product(int n){

        int multiply=1;

        while(n>0){
            int remainder = n%10;
            multiply = multiply*remainder;
            n = n/10;
        }
        return multiply;
    }


    public int sum(int n){

        int addition = 0;

        while(n>0){
        int remainder = n%10;
        addition = addition + remainder;
        n = n/10;
        }

        return addition;
    }
}