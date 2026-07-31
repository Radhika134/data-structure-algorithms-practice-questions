class Solution {
public:
    vector<int> toggleLightBulbs(vector<int>& bulbs) {
        map<int,int> mp;
        vector<int> ans;

        for(auto val: bulbs)
        {
            mp[val]++;
        }

        for(auto val : mp)
        {
            if(val.second % 2 == 1)
            {
                ans.push_back(val.first);
            }
        }

        return ans;
    }
};