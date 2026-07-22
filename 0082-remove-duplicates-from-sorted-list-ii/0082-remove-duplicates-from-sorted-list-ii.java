class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Write your code here
        if(head == null) return null;
        ListNode curr = head;
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        while(curr!=null && curr.next!=null)
        {
            if(curr.val != curr.next.val)
            {
                ptr.next = curr;
                ptr = ptr.next;
            }
            else
            {
                while(curr.next!=null && curr.val == curr.next.val)
                {
                    curr = curr.next;
                }
            }
           // prev = curr;
            curr=curr.next;
        }
        ptr.next = curr;
        return dummy.next;
    }
}