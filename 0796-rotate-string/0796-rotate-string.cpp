class Solution {
public:
    bool rotateK(string s, string goal, int k) {
        int n = s.size();
        vector<char> ans(n);
        int j = 0;
        while (j < n) {
            ans[(j + k) % n] = goal[j];
            j++;
        }
        string result(ans.begin(), ans.end());
        return result == s;
    }
    bool rotateString(string s, string goal) {
        int i = 0;
        int k = 0;
        int n = s.size();
        while (i < goal.size()) {
            if (s[0] == goal[i]) {
                k = goal.size() - i;
            }
            if (rotateK(s, goal, k))
                return true;
            i++;
        }

        return rotateK(s, goal, k);
    }



    // bool rotateString(string s, string goal) {
    // if (s.size() != goal.size()) return false;
    // string doubled = s + s;
    // return (int)doubled.find(goal) != -1;

};