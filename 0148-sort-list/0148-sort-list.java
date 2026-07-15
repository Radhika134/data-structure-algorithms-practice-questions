
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
   
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast!=null && fast.next!= null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        head = sortList(head);
        slow = sortList(slow);

        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;

        while(head!=null && slow!=null)
        {
            if(head.val < slow.val)
            {
                curr.next = head;
                curr = curr.next;
                head = head.next;
            }
            else
            {
                curr.next = slow;
                curr = curr.next;
                slow = slow.next;
            }
        }
        if(head!= null)
        {
            curr.next = head;
            curr = curr.next;
        }
        else if(slow!= null)
        {
            curr.next = slow;
            curr = curr.next;
        }
        return newHead.next;

    }
}