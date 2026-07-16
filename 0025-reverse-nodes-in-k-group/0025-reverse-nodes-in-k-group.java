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
    ListNode newHead = new ListNode(0);
    ListNode ptr = newHead;

    ListNode reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null)
        {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;

        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        
        int ogK = k;
        ListNode countPtr = head;
        int count = 0;
        while(countPtr!=null)
        {
            count++;
            countPtr = countPtr.next;
        }
        if(k>count)
        {
            ptr.next = head;
            return newHead;
        }

        ListNode curr = head;
        ListNode start = head;
        ListNode prev = null;

        while(k>0 && curr!=null)
        {
            prev = curr;
            curr = curr.next;
            k--;
        }
        
        prev.next = null;

        ptr.next = reverse(start);
        ptr = start;

        reverseKGroup(curr,ogK);

        return newHead.next;

    }
}