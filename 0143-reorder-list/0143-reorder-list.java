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
    public void reorderList(ListNode head){

        if(head == null || head.next == null){
            return;
        }

        ListNode middle = middle(head);
        ListNode secondhead = reverse(middle.next);
        middle.next = null;
        ListNode firsthead = head;

        while(secondhead!=null){
            ListNode temp1 = firsthead.next;
            ListNode temp2 = secondhead.next;
            firsthead.next = secondhead;
            secondhead.next = temp1;
            firsthead = temp1;;
            secondhead = temp2;
        }
        
    }


    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode present = head;
        while(present!=null){
            ListNode next = present.next;
            present.next = prev;
            prev = present;
            present = next;
        }
        return prev;
    }

    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}