class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stk = new Stack<>();
        int n = num.length();

        for(int i = 0;i<n;i++)
        {
            int x = num.charAt(i) - '0';
            while(!stk.isEmpty() && stk.peek() > x && k>0)
            {
                stk.pop();
                k--;
            }
            stk.push(x);
         

        }

        while(!stk.isEmpty() && k > 0)
        {
            stk.pop();
            k--;
           
        }


        if(stk.isEmpty()) return "0";

        StringBuilder str = new StringBuilder();
        while(!stk.isEmpty())
        {
            str.append(stk.pop());
        }
        str.reverse();

        int i = 0;
        while(i != str.length() && str.charAt(i) == '0')
        {
            i++;
        }
        
        if(i == str.length()) return "0";
        return str.substring(i);   //it returns a string
        
    }
}