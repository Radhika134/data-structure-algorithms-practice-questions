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
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null)
        {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr=curr.next;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        // ListNode head1 = reverse(l1);
        // ListNode head2 = reverse(l2);
        ListNode ptr1 = head1;
        ListNode ptr2 = head2;
        int carry = 0;
        
        ListNode newHead = new ListNode(1);
        ListNode curr = newHead;
         

        while(ptr1!=null && ptr2!=null)
        {
            
                curr.next = new ListNode((ptr1.val + ptr2.val + carry) % 10);
                carry = (ptr1.val + ptr2.val + carry) / 10;
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;

                curr = curr.next;
        }
        if(ptr1!=null)
        {
            while(ptr1!=null)
            {
            curr.next = new ListNode((ptr1.val + carry) % 10);
            carry = (ptr1.val + carry) / 10;
            curr = curr.next;
            ptr1 = ptr1.next;
            }
        }
        else if(ptr2!=null)
        {
            while(ptr2!=null)
            {
            curr.next = new ListNode((ptr2.val + carry) % 10);
            carry = (ptr2.val + carry) / 10;
            curr = curr.next;
            ptr2 = ptr2.next;
            }
        }
        if(carry == 1)
        {
            curr.next = new ListNode(1);
        }

        return newHead.next;
    }
}