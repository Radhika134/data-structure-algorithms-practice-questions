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
            curr = nxt;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Write your code here
        if(head == null) return null;
        if( left == right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode ptr = head;
        ListNode prev = null;
        int l = 1;
        while(ptr!=null)
        {
            if(l == left)
            {
                break;
            }
            l++;
            prev = ptr;
            ptr = ptr.next;
        }
        ListNode first = null;
        if(prev == null)
        {
            first = dummy;
        }
        else{
            first = prev;
        }
        //ListNode middle = reverse(ptr);
        ListNode ptr1 = head;
        int r = 1;
        while(ptr1!=null)
        {
            if(r == right)
            {
                break;
            }
            r++;
            ptr1=ptr1.next;
        }
        ListNode last = ptr1.next;
        ptr1.next = null;
        ListNode middle = reverse(ptr);
        first.next = middle;
        ptr.next = last;
        return dummy.next;
    }
}