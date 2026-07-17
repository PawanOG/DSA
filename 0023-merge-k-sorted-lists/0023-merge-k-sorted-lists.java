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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode mergedlist = null;
        int i = 0;
        while (i < lists.length) {
            mergedlist = merge2list(mergedlist, lists[i]);
            i++;
        }
        return mergedlist;
    }

    public ListNode merge2list(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val <= l2.val) {
            l1.next = merge2list(l1.next, l2);
            return l1;
        } else {
            l2.next = merge2list(l1, l2.next);
            return l2;
        }
    }
}