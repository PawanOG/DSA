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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        // ham mainly koshish krre hai ki prev ko left node se just pehele place krwa paye
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // curr hamesha reverse hone wale part ki first node pe rahega
        ListNode curr = prev.next;

        // jitne nodes reverse krne hai utni baar loop chalega
        for (int i = 0; i < right - left; i++) {

            // curr ke next node ko temporarily store kr liya
            ListNode temp = curr.next;

            // curr ko temp se alag kr diya aur curr ko temp ke next se jod diya
            // matlab curr ab directly aage wale node ko point krega
            curr.next = temp.next;

            // temp ko prev ke next se connect kr diya
            // yani temp ab reverse part ke starting me aa jayega
            temp.next = prev.next;

            // ab prev ko temp se connect kr diya
            // isse temp reverse part ka naya first node ban gaya
            prev.next = temp;
        }

        return dummy.next;
    }
}