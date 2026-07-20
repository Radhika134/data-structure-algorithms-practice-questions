class Solution {
public:
    string removeOuterParentheses(string s) {
        string str = "";
        int depth = 0;
        for (auto ch : s) {

            if (ch == '(')
            {
                depth++;

                if (depth > 1) {
                    str += ch;
                }
            }
            else
            {
                if(ch == ')')
                {
                    depth--;

                    if(depth > 0)
                    {
                        str+=ch;
                    }
                }
            }
        }
        return str;
    }
};