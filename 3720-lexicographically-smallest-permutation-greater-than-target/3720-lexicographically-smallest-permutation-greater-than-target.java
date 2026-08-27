class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = target.charAt(i) - 'a';

            if (cnt[x] > 0) {
                cnt[x]--;
                prefix.append((char) ('a' + x));
            } else {
                int greater = findGreater(cnt, x);

                if (greater != -1) {
                    return build(prefix, greater, cnt);
                }

                break;
            }
        }

        for (int i = prefix.length() - 1; i >= 0; i--) {
            int x = target.charAt(i) - 'a';

            cnt[x]++;

            int greater = findGreater(cnt, x);

            if (greater != -1) {
                prefix.setLength(i);
                return build(prefix, greater, cnt);
            }
        }

        return "";
    }

    private int findGreater(int[] cnt, int x) {
        for (int c = x + 1; c < 26; c++) {
            if (cnt[c] > 0) {
                return c;
            }
        }
        return -1;
    }

    private String build(StringBuilder prefix, int greater, int[] cnt) {
        StringBuilder ans = new StringBuilder(prefix);

        ans.append((char) ('a' + greater));
        cnt[greater]--;

        for (int c = 0; c < 26; c++) {
            while (cnt[c] > 0) {
                ans.append((char) ('a' + c));
                cnt[c]--;
            }
        }

        return ans.toString();
    }
}