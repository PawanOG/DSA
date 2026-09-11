class Solution {
    public int distMoney(int money, int children) {

        // Give everyone $1
        if (money < children) {
            return -1;
        }

        money -= children;

        // Each $8 child needs 7 extra dollars
        int count = money / 7;

        // Can't have more than 'children' $8 children
        if (count > children) {
            count = children;
        }

        int remaining = money - (count * 7);

        // If all children are $8, but extra money exists,
        // one child must take the extra money.
        if (count == children && remaining > 0) {
            count--;
            remaining += 7;
        }

        // If exactly one child is left and it would receive $4,
        // reduce one $8 child.
        if (count == children - 1 && remaining == 3) {
            count--;
        }

        return count;
    }
}