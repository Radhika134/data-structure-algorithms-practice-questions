class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        for(int i = 0; i<n; i++)
        {
            sum += nums[i];
            int rem = sum % k;
            if(rem < 0)     //rem neg ho skta h isliye normalize kra
            {
                rem = rem + k;
            }
            if(mpp.containsKey(rem))
            {
                ans += mpp.get(rem);

            }
            mpp.put(rem, mpp.getOrDefault(rem, 0) + 1);

        }

        return ans;
    }
}