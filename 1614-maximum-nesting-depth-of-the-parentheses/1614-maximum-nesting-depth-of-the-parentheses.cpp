class Solution {
public:
    int maxDepth(string s) {
        int depth = 0;
        int maxAns = 0;
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
        return maxAns;
        
       
        
    }
};