class Solution {
public:
    int maxDepth(string s) {
        int depth = 0;
        int maxAns = INT_MIN;
        for(int i=0;i<s.size();i++)
        {
            char ch = s[i];
            if(ch == '(')
            {
                depth++;
                maxAns = max(maxAns, depth);
            }
            else if(ch == ')')
            {
                depth--;
            }
        }
        if(maxAns!=INT_MIN) return maxAns;
        return 0;
       
        
    }
};