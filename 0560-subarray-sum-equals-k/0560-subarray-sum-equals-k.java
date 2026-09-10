class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        int ans = 0, currSum = 0;
        for(int i = 0;i<nums.length;i++)
        {
            currSum += nums[i];
            if(mpp.containsKey(currSum-k))
            {
                ans = ans + mpp.get(currSum - k);
            }
            mpp.put(currSum, mpp.getOrDefault(currSum, 0) + 1);
        }
        return ans;
    }
}