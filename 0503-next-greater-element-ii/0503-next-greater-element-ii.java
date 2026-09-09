class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        
        int n = nums.length;
        int[] res = new int[n];

        for(int i = n*2-1; i>=0;i--)
        {
            int idx = i%n;
            while(!stk.isEmpty() && stk.peek() <= nums[idx])
            {
                stk.pop();
            }
            if(stk.isEmpty())
            {
                res[idx] = -1;
            }
            else
            {
                res[idx] = stk.peek();
            }
            stk.push(nums[idx]);
        }
        return res;
    }
}