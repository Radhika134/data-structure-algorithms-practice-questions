class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int []res = new int[nums1.length];

        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i = nums2.length-1; i>=0; i--)
        {
            int num = nums2[i];
            // if(Stk.isEmpty()) stk.push(num);

            while(!stk.isEmpty() && stk.peek() < num)
            {
                stk.pop();
            }
            
            if(stk.isEmpty())
            {
                mpp.put(num, -1);
            }
            else
            {
                mpp.put(num, stk.peek());
            }
            stk.push(num);
        }
        for(int i = 0;i<nums1.length;i++)
        {
            res[i] = mpp.get(nums1[i]);
        }
        return res;
        
    }
}