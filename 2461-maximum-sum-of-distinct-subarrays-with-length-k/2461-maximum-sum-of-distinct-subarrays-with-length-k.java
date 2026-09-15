class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        int left = 0, right = 0;
        long maxSum = 0;

        long sum = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i<k; i++)
        {
            sum += nums[right];
            mpp.put(nums[right], mpp.getOrDefault(nums[right], 0) + 1);
            right++;

        }
        if(mpp.size() == k)
        {
        maxSum = Math.max(maxSum, sum);
        }

        for(right = k; right<n; right++)
        {
            sum += nums[right];
            sum -= nums[left];

            mpp.put(nums[right], mpp.getOrDefault(nums[right], 0) + 1);
            mpp.put(nums[left], mpp.get(nums[left]) - 1);

            if(mpp.get(nums[left]) == 0)
            {
                mpp.remove(nums[left]);
            }
            left++;

            if(mpp.size() == k && right-left+1 == k)
            {
                maxSum = Math.max(sum, maxSum);
            }
        }

    

        return maxSum;


    }
}