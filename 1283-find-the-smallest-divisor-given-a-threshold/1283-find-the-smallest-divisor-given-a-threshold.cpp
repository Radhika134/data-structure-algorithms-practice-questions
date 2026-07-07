class Solution {
public:
    int maxDivisor(vector<int> & nums,int n)
    {
        int maxi = INT_MAX;
        for(int i=0;i<n;i++)
        {
            maxi = max(maxi,nums[i]);
        }
        return maxi;
    }
    
    int result(vector<int> &nums,int n,int mid)
    {
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum += ceil((double)nums[i] / (double)mid);
        }
        return sum;
    }

    int smallestDivisor(vector<int>& nums, int threshold) {
        int n = nums.size();
        int ans = 0;

        int low = 1, high = maxDivisor(nums, n);
        while(low<=high)
        {
            int mid = low+((high-low)/2);
            int val = result(nums,n,mid);

            if(val<=threshold)
            {
                ans = mid;
                high = mid-1;

            }
            else low = mid+1;

        }

        return ans;
    }
};