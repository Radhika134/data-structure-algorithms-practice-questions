class Solution {
public:
    bool detectCapitalUse(string word) {
        int capCount = 0;

        for (int i = 0; i < word.length(); i++) {
            if (isupper(word[i])) {
                capCount++;
            }
        }

        return (capCount == 0) || (capCount == word.length()) ||
               (capCount == 1 && isupper(word[0]));
    }
};