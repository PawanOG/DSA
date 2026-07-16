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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1!=null || l2!=null || carry!=0){
            int val,val1,val2;
            if(l1!=null){
            val1 = l1.val;
            l1 = l1.next;
            }else{
                val1=0;
            }
            if(l2!=null){
            val2 = l2.val;
            l2 = l2.next;
            }else{
                val2=0;
            }
            val = val1+val2+carry;
            carry = val/10;
            val = val%10;
            
            curr.next = new ListNode(val);

            curr = curr.next;

        }
        return dummy.next;
    }
}