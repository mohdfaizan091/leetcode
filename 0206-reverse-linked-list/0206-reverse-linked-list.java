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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = null;
        ListNode Next = temp;
        ListNode curr = head;
        ListNode prev = head.next;
        while(prev != null) {
            curr.next = Next;
            Next = curr;
            curr = prev;
            prev = prev.next;
        }
        curr.next = Next;

        return curr;
    }
}