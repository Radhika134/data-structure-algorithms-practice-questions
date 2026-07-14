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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        

        ListNode prev = null;
        ListNode curr = head;
        int count = 0;

        while(curr!=null)
        {
            count++;
            curr = curr.next;
        }
       

        int k = count-n;
        if(k == 0) return head.next;
        
        curr = head;
        while(k > 0 && curr!=null)
        {
            k--;
            prev = curr;
            curr=curr.next;
        }
        
        
        prev.next = curr.next;

        return head;
        
    }
}