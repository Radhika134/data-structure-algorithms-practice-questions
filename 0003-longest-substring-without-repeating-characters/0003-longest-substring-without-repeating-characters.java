class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();
    
        int left = 0, right = 0, maxLen = 0;
        for(right = 0;right<s.length(); right++)
        {
            char ch = s.charAt(right);
            if(st.contains(ch))
            {
                while(s.charAt(left) != ch)
                {
                    st.remove(s.charAt(left));
                    left++;
                }
                st.remove(s.charAt(left));
                left++;
            }
            st.add(ch);
            maxLen = Math.max(maxLen, right-left+1);

        }


        return maxLen;
    }
}