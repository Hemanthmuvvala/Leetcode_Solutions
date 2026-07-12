// Last updated: 7/12/2026, 11:13:07 PM
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
// Definition for singly-linked list.


class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) s.add(x);
        ListNode d = new ListNode(0, head);
        ListNode p = d;
        while (p.next != null) {
            if (s.contains(p.next.val)) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return d.next;
    }
}
