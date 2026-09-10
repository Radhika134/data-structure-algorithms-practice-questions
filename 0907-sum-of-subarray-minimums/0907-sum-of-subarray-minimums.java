class Solution {
    
    public int[] findNSE(int[] arr)
    {
        Stack<Integer> stk1 = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for(int i = n-1; i>=0; i--)
        {
            while(!stk1.isEmpty() && arr[stk1.peek()] >= arr[i])
            {
                stk1.pop();

            }
            if(stk1.isEmpty()) ans[i] = n;      //if not exist nse then n
            else  ans[i] = stk1.peek();

            stk1.push(i);
        }
        return ans;

    }

    public int[] findPSE(int[] arr)
    {
        Stack<Integer> stk2 = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for(int i = 0; i<n; i++)
        {
            while(!stk2.isEmpty() && arr[stk2.peek()] > arr[i])
            {
                stk2.pop();

            }
            if(stk2.isEmpty()) ans[i] = -1;  //if not exist pse then -1
            else  ans[i] = stk2.peek();

            stk2.push(i);
        }
        return ans;

    }


    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int total = 0;
        int mod = (int)(1e9 + 7);

        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        for(int i = 0; i < n; i++)
        {
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = left*right*1L;
            int contribution = (int)((freq*arr[i]) % mod);

            total = (total + contribution) % mod;

        }
       
        return total;
    }
}