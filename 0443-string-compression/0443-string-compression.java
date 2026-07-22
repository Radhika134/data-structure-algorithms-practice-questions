class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0, k = 0;

        while(i<n)
        {
            int j = i;
            while(j<n && chars[j] == chars[i] )
            {
                j++;
            }

            chars[k++] = chars[i];

            int count = j-i;
            if(count > 1)
            {
                String s = String.valueOf(count);
                for(char c : s.toCharArray())
                {
                    chars[k++] = c;
                }
            }
           
            i=j;
        }
        return k;
        
    }
}