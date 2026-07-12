// Last updated: 7/12/2026, 11:14:56 PM
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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slowPointer=head,fastPointer=head.next.next;
            
        while(fastPointer!=null && fastPointer.next!=null){
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next.next;
        }

        slowPointer.next=slowPointer.next.next;

        return head;
    }
}