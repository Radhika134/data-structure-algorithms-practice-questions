class Solution {
public:
    string reverseWords(string s) {
        vector<string> words ;
        string temp = "";

        for(auto ch : s)
        {
            if(ch != ' ')
            {
                temp+=ch;
            }
            else //ch == ' 
            {
                if(temp!="")
                {
                    words.push_back(temp);
                    temp = "";
                }
            }
        }
        if(temp!="")
        {
            words.push_back(temp);
            temp = "";
        }

        // temp = "";


       //basically ye java ka split func manually bnaya


        for(int i = words.size()-1; i>=0; i--)
        {
            temp+=words[i];
            if(i > 0)
            {
                temp+=" ";
            }
        }
        return temp;
        

        
    }
};