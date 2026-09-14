class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hashFreq = new int[256];
        Arrays.fill(hashFreq, 0);
    
        int left = 0, right = 0;
        int maxLen = 0;
        for(right = 0;right<s.length(); right++)
        {
            char ch = s.charAt(right);
            hashFreq[ch]++; 
           
            while(hashFreq[ch] > 1)
            {
                hashFreq[s.charAt(left)]--;
                left++;
            }
                

            maxLen = Math.max(maxLen, right-left+1);

        }


        return maxLen;
    }
}