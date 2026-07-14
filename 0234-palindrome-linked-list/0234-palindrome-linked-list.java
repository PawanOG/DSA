/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public boolean isPalindrome(ListNode head) {

        // Agar list empty ya sirf ek node ki hai to wo palindrome hi hogi
        if(head == null || head.next == null){
            return true;
        }

        // Middle node nikal lo
        ListNode middle = middleNode(head);

        // Middle se second half reverse kar do
        ListNode secondHead = reverse(middle);

        // Compare karne ke liye pointers
        ListNode first = head;
        ListNode second = secondHead;

        while(second != null){

            // Agar value alag mili to palindrome nahi hai
            if(first.val != second.val){
                return false;
            }

            first = first.next;
            second = second.next;
        }

        return true;
    }

    public ListNode middleNode(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        // Fast 2 step chalega aur slow 1 step
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow middle par aa gaya
        return slow;
    }

    public ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode present = head;

        while(present != null){

            // Next node save kar lo
            ListNode next = present.next;

            // Link ulta kar do
            present.next = prev;

            // Prev aur present ko aage badhao
            prev = present;
            present = next;
        }

        // Prev naya head hai
        return prev;
    }
}
