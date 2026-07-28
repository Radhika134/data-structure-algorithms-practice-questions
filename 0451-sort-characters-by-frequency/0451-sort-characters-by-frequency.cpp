class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char,int> m;

        for(int i=0;i<s.size();i++)
        {
            m[s[i]]++;
        }

        string ans = "";
        priority_queue<pair<int,char>> maxHeap;

        for(auto it:m)
        {
            maxHeap.push({it.second, it.first});
        }
        
        while(!maxHeap.empty())
        {
            int count = maxHeap.top().first;
            char ch = maxHeap.top().second;
            maxHeap.pop();
            ans+=string(count, ch);
        }
        return ans;
    }
};