class Solution {
    public int beautySum(String s) {

        int ans = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];
            int maxFreq = 0;

            for (int j = i; j < n; j++) {

                int index = s.charAt(j) - 'a';
                freq[index]++;

                maxFreq = Math.max(maxFreq, freq[index]);

                int minFreq = Integer.MAX_VALUE;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }

                ans += maxFreq - minFreq;
            }
        }

        return ans;
    }
}