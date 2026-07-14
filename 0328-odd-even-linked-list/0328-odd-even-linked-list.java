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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;

        
        ListNode evenLL = head.next;
        ListNode oddLL = head;

        ListNode oddptr = head;
        ListNode evenptr = head.next;

        ListNode even = evenLL;
        ListNode odd = oddLL;

        while(oddptr.next!= null && evenptr.next!= null)
        {
            oddptr = oddptr.next.next;
            evenptr = evenptr.next.next;

            even.next = evenptr;
            even = evenptr;

            odd.next = oddptr;
            odd = oddptr;


        }

        odd.next = evenLL;
        return oddLL;
        
    }
}