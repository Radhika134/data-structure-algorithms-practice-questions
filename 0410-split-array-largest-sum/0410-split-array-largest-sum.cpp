class Solution {
public:
    int isPossible(vector<int>& nums, int n, int mid)
    {
        int maxSum = 0, subArrays = 1;
        for(int i=0;i<n;i++)
        {
            
            if(maxSum + nums[i] > mid)
            {
                subArrays++;
                maxSum = nums[i];
            }
            else
            {
                maxSum+=nums[i];
            }

        }
        return subArrays;

    }

    int splitArray(vector<int>& nums, int k) {

        int n = nums.size();

        int low = *max_element(nums.begin(), nums.end());
        int high = accumulate(nums.begin(), nums.end(), 0);
        int ans = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            int possibleArrays = isPossible(nums, n, mid);
            if(possibleArrays > k)
            {
                low = mid+1;
            }
            else if(possibleArrays <=k )
            {
                ans = mid;
                high = mid-1;

            }
        }
        return ans;
    }
};