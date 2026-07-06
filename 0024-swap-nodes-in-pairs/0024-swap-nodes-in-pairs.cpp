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
    ListNode* swapPairs(ListNode* head) {
        if (head == nullptr)
            return nullptr;

        ListNode* dummy = new ListNode(0);
        dummy->next = head;

        ListNode* second = head->next;
        ListNode* first = head;
        ListNode* prev = dummy;

        while (first != nullptr && first->next != nullptr) {

            ListNode* nxt = second->next;
            prev->next = second;
            second->next = first;
            first->next = nxt;

            prev = first;
            first = nxt;
            second = (first != nullptr) ? first->next : nullptr;
        }
        return dummy->next;
    }
};