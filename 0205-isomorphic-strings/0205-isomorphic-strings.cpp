class Solution {
public:
    bool isIsomorphic(string s, string t) {
        map<char,char> mpp1;
        map<char,char> mpp2;

        if(s.size() != t.size()) return false;
        for(int i = 0;i<s.size();i++)
        {
            if(mpp1.count(s[i]))
            {
                if(mpp1[s[i]] != t[i]) return false;
               
            }
             else
                mpp1[s[i]] = t[i];

            if(mpp2.count(t[i]))
            {
                if(mpp2[t[i]] != s[i]) return false;

            }   
            else
            mpp2[t[i]] = s[i];
           
        }
        
        return true;

        
    }
};