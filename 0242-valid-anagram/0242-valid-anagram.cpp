class Solution {
public:
    bool isAnagram(string s, string t) {
        map<char,int> m1;
        map<char,int> m2;
        if(s.size()!=t.size()) return false;
        
        for(int i=0;i<s.size();i++)
        {
            m1[s[i]]++;
        }
        for(int i=0;i<t.size();i++)
        {
            m2[t[i]]++;
        }
        for(char i='a';i<='z';i++)
        {
            
            if(m1[i] != m2[i]) return false;
            
           
        }

        return true;
    }
};