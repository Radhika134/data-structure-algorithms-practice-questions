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
    ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null)
        {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null) //1middle pr jaega
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode newhead = reverse(slow.next);
        slow.next = null;

        while(newhead != null && head != null)
        {
            if(newhead.val != head.val) return false;
            head = head.next;
            newhead = newhead.next;
        }
        return true;
    }
}