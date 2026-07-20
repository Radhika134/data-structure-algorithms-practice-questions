class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder sb = new StringBuilder();
        int depth = 0;
        for (char ch : s.toCharArray()) {

            if (ch == '(')
            {
                depth++;

                if (depth > 1) {
                    sb.append(ch);
                }
            }
            else
            {
                if(ch == ')')
                {
                    depth--;

                    if(depth > 0)
                    {
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
        
        
    }
}