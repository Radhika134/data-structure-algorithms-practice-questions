class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) return "";

        int[] half = new int[26];
        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
        }

        int halfLen = n / 2;
        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            boolean found = false;

            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;
                left.append((char) ('a' + c));

                if (canMakeGreater(left, half, mid, target)) {
                    found = true;
                    break;
                }

                left.deleteCharAt(left.length() - 1);
                half[c]++;
            }

            if (!found) return "";
        }

        StringBuilder ans = new StringBuilder(left);

        if (n % 2 == 1) {
            ans.append(mid);
        }

        for (int i = left.length() - 1; i >= 0; i--) {
            ans.append(left.charAt(i));
        }

        return ans.toString().compareTo(target) > 0 ? ans.toString() : "";
    }

    private boolean canMakeGreater(
        StringBuilder left,
        int[] half,
        char mid,
        String target
    ) {
        StringBuilder maxLeft = new StringBuilder(left);

        for (int c = 25; c >= 0; c--) {
            for (int k = 0; k < half[c]; k++) {
                maxLeft.append((char) ('a' + c));
            }
        }

        StringBuilder candidate = new StringBuilder(maxLeft);

        if (target.length() % 2 == 1) {
            candidate.append(mid);
        }

        for (int i = maxLeft.length() - 1; i >= 0; i--) {
            candidate.append(maxLeft.charAt(i));
        }

        return candidate.toString().compareTo(target) > 0;
    }
}