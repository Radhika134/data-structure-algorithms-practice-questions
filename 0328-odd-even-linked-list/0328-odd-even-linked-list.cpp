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
    ListNode* oddEvenList(ListNode* head) {
        
         if(head == nullptr) return nullptr;

        
        ListNode* evenLL = head->next;
        ListNode* oddLL = head;

        ListNode* oddptr = head;
        ListNode* evenptr = head->next;

        ListNode* even = evenLL;
        ListNode* odd = oddLL;

        while(oddptr->next!= nullptr && evenptr->next!= nullptr)
        {
            oddptr = oddptr->next->next;
            evenptr = evenptr->next->next;

            even->next = evenptr;
            even = evenptr;

            odd->next = oddptr;
            odd = oddptr;


        }

        odd->next = evenLL;
        return oddLL;
    }
};