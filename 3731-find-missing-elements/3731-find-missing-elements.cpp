class Solution {
public:
    vector<int> findMissingElements(vector<int>& nums) {
        vector<int> ans;

        sort(nums.begin(),nums.end());
        int mini = *min_element(nums.begin(), nums.end());
        int maxi = *max_element(nums.begin(), nums.end());
        int j = 0;
        for(int i = mini;i<=maxi;i++)
        {
            if(i != nums[j])
            {
                ans.push_back(i);

            }
            else{
            j++;
            }

        }

        return ans;
    }
};