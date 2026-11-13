class Solution {
public:
    int fun(string &text1, string &text2, int m, int n, vector<vector<int>> &dp)
    {
        if(m == 0 || n == 0) return 0; 
        if(dp[m][n] != -1) return dp[m][n]; 
        if(text1[m-1] == text2[n-1])
        {
            return dp[m][n] = 1 + fun(text1, text2, m-1, n-1, dp);
        } 
        return dp[m][n] = max
        (
            fun(text1, text2, m-1, n, dp),
            fun(text1, text2, m, n-1, dp)
        );
    }

    int longestCommonSubsequence(string text1, string text2)
    {
        int m = text1.size();
        int n = text2.size(); 
        vector<vector<int>> dp(m+1, vector<int>(n+1, -1));
        for(int i=0;i<=m;i++) dp[i][0] = 0;
        for(int i=0;i<=n;i++) dp[0][i] = 0; 
        return fun(text1, text2, m, n, dp);
    }
};