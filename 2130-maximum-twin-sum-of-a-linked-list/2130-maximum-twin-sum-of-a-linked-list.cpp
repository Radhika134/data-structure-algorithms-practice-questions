/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverse(ListNode* head)
    {
        ListNode* curr = head;
        ListNode* prev = nullptr;
        
        while(curr)
        {
            ListNode* next = curr->next;
            curr->next = prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }

    int pairSum(ListNode* head) {
        if(head == nullptr) return -1;

        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* ptr = nullptr;

        while(fast!=nullptr && fast->next!=nullptr)
        {
            ptr = slow;
            slow=slow->next;
            fast=fast->next->next;


        }

        ptr->next = nullptr;       //break of list1
        ListNode* newHead = reverse(slow);  //new list

        int max = INT_MIN;

        while(head && newHead)
        {
            int sum = head->val + newHead->val;
            if(sum > max)
            {
                max = sum;
            }

            head = head->next;
            newHead = newHead->next;
        }
        return max;



        
    }
};