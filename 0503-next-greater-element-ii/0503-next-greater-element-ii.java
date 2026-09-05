class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for(int i = 0;i<n;i++)
        {
            int num = nums[i];
            for(int j = i+1; j<n+i; j++)
            {
                int idx = j%n;
                if(nums[idx] > num)
                {
                    res[i]=nums[idx];
                    break;
                }

            }
            
        }
        return res;
        
    }
}