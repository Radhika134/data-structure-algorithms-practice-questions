class Solution {
public:
    bool isVowel(char a) {
        return (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' ||
                a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U');
    }
    string reverseVowels(string s) {
        int n = s.size();
        // s.toLowerCase();
        for (int i = 0, j = n - 1; i < j;) {
            if (!isVowel(s[i])) {
                i++;
            }
            if (!isVowel(s[j])) {
                j--;
            }
            if (isVowel(s[i]) && isVowel(s[j])) {
                swap(s[i], s[j]);
                i++;
                j--;
            }
        }
        return s;
    }
};