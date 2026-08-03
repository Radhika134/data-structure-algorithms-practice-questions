class Solution {
public:
    string stoneGameIII(vector<int>& a) {
        int n = a.size();
        vector<int> dp(n + 1, 0);

        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            dp[i] = INT_MIN;

            for (int j = 0; j < 3 && i + j < n; j++) {
                sum += a[i + j];
                dp[i] = max(dp[i], sum - dp[i + j + 1]);
            }
        }

        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }
};