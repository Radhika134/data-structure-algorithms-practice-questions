class Solution {
    public int[] NGE(int[] nums)
    {
        Stack<Integer> stk = new Stack<>();
        int[]res = new int[nums.length];
        int n = nums.length;

        for(int i = n-1; i>=0; i--)
        {
            while(!stk.isEmpty() && nums[stk.peek()] <= nums[i])
            {
                stk.pop();
            }
            if(stk.isEmpty()) res[i] = n; 
            else
            {
                res[i] = stk.peek();
            }

            stk.push(i);
        }
        return res;
    }

    public int[] PGE(int[] nums)
    {
        Stack<Integer> stk = new Stack<>();
        int[]res = new int[nums.length];
        int n = nums.length;

        for(int i = 0; i<n; i++)
        {
            while(!stk.isEmpty() && nums[stk.peek()] < nums[i])  //For duplicates, one side strict aur one side non-strict:
            {
                stk.pop();
            }
            if(stk.isEmpty()) res[i] = -1; 
            else
            {
                res[i] = stk.peek();
            }

            stk.push(i);
        }
        return res;
    }

    public int[] NSE(int[] nums)
    {
        Stack<Integer> stk = new Stack<>();
        int[]res = new int[nums.length];
        int n = nums.length;

        for(int i = n-1; i>=0; i--)
        {
            while(!stk.isEmpty() && nums[stk.peek()] >= nums[i])
            {
                stk.pop();
            }
            if(stk.isEmpty()) res[i] = n; 
            else
            {
                res[i] = stk.peek();
            }

            stk.push(i);
        }
        return res;
    }

    public int[] PSE(int[] nums)
    {
        Stack<Integer> stk = new Stack<>();
        int[]res = new int[nums.length];
        int n = nums.length;

        for(int i = 0; i<n; i++)
        {
            while(!stk.isEmpty() && nums[stk.peek()] > nums[i])
            {
                stk.pop();
            }
            if(stk.isEmpty()) res[i] = -1; 
            else
            {
                res[i] = stk.peek();
            }

            stk.push(i);
        }
        return res;
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] nge = NGE(nums);
        int[] nse = NSE(nums);
        int[] pse = PSE(nums);
        int[] pge = PGE(nums);

        long sum = 0;


        for(int i = 0;i<n;i++)
        {
            int left1 = i - pge[i];
            int right1 = nge[i] - i;
            long freq1 = left1*right1*1L;
            sum += freq1*nums[i]*1L;

            int left2 = i - pse[i];
            int right2 = nse[i] - i;
            long freq2 = left2*right2*1L;
            sum -= freq2*nums[i]*1L;

        }


        return sum ;
    }
}