class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        int n = s.length();
        
        for(int i=1;i<=n/2;i++)
        {
            if(n % i != 0)
            {
                continue;
            }
            String pattern = s.substring(0,i);

            StringBuilder ans = new StringBuilder();
            while(ans.length() < n)
            {
                ans.append(pattern);
            }

            if(ans.toString().equals(s)) return true;


        }
        return false;
    }
}