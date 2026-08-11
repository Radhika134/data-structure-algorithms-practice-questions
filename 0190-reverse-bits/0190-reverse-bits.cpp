class Solution {
public:
    int reverseBits(int n) {
        stack<int> s;

        // Original bits ko stack me daalo
        for (int i = 0; i < 32; i++) {
            s.push(n & 1);
            n = n >> 1;
        }

        unsigned int ans = 0;
        unsigned int place = 1;

        // Stack se pop karke reversed positions par rakho
        while (!s.empty()) {
            ans = ans + s.top() * place;
            place = place * 2;
            s.pop();
        }

        return ans;
    }
};