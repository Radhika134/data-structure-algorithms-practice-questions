class Solution {
public:
    void expand(string &s, int left, int right, int &start, int &longLen)
    {
         while(left>=0 && right<s.size() && s[left] == s[right])
            {
                int len = right - left + 1;
                if(longLen < len)
                {
                    start = left;
                    longLen = len;
                }
                left--;
                right++;


            }
        
    }

    string longestPalindrome(string s) {
        int start = 0;
        int longLen = 0;
        for(int i=0;i<s.size();i++)
        {
            int mid = i;
            //odd length
            expand(s, mid, mid, start, longLen);
            //even length
            expand(s, mid, mid+1, start, longLen);  
           
        }
        return s.substr(start, longLen);
    }
};