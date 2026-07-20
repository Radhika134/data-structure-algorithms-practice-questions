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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode curr = head;
        int len = 0;
        while(curr!=null)
        {
            len++;
            curr=curr.next;

        }
        
        k = k % len;
        while(k>0)
        {
            ListNode ptr = head;
            ListNode prev = null;
            
            while(ptr.next!=null)
            {
                prev = ptr;
                ptr=ptr.next;
            }

            prev.next = null;
            ptr.next = head;
            head = ptr;

            k--;
        }

        return head;
        
    }
}