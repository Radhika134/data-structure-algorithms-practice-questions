class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        String prefix = strs[0];

        for(int i=1;i<strs.length;i++)
        {
            String temp = strs[i];
            int j = 0;
            while(j<temp.length() && j<prefix.length() && prefix.charAt(j) == temp.charAt(j))
            {
                j++;

            }

            prefix = prefix.substring(0,j);

            if(prefix.isEmpty()) return "";
        }
        return prefix;
    }
}