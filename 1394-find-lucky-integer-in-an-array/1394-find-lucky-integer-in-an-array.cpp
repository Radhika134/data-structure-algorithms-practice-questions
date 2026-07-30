class Solution {
public:
    int findLucky(vector<int>& arr) {
        unordered_map<int, int> mp;

        for (int i = 0; i < arr.size(); i++) {
            mp[arr[i]]++;
        }
        int max = -99;
        for (auto val : mp) {
            if (val.first == val.second) {
                if (val.first > max) {
                    max = val.first;
                }
            }
        }
        if (max == -99) {
            return -1;
        } else {
            return max;
        }
    }
};