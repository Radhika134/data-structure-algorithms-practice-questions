class Solution {
public:
    bool stoneGameIX(vector<int>& stones) {
        int cnt[3] = {0, 0, 0};

        for (int x : stones) {
            cnt[x % 3]++;
        }

        // Alice wins if:
        // 1. Number of stones divisible by 3 is even
        //    and both remainder groups exist
        // 2. Number of stones divisible by 3 is odd
        //    and one remainder group has at least 2 more stones
        //    than the other.

        if (cnt[0] % 2 == 0) {
            return cnt[1] > 0 && cnt[2] > 0;
        }

        return abs(cnt[1] - cnt[2]) > 2;
    }
};