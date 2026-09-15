
class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode d1 = dummy;
        ListNode list1 = head1;
        ListNode list2 = head2;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                d1.next = list1;
                list1 = list1.next;
                d1 = d1.next;
            } else {
                d1.next = list2;
                list2 = list2.next;
                d1 = d1.next;
            }
        }
        if(list1 != null) {
            d1.next = list1;
        }
        if(list2 != null) {
            d1.next = list2;
        }
        return dummy.next;
    }
}