class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        int xorAll = 0;
        bool hasNonZero = false;
        
        for (int x : nums) {
            xorAll ^= x;
            if (x != 0) hasNonZero = true;
        }
        
        if (!hasNonZero) return 0;          // sab elements zero
        if (xorAll != 0) return nums.size(); // pura array kaam kar gaya
        return nums.size() - 1;              // ek non-zero element hata do
    }
};