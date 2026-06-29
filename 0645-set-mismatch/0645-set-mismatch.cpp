class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {

        int repeating = -1, missing = -1;
        for(int i=1;i<=nums.size();i++)
        {
            int count = 0;
            for(int j=0;j<nums.size();j++)
            {
                if(nums[j] == i) count++;

            }
            if(count == 2) repeating = i;
            else if(count == 0) missing = i;

            if(repeating != -1 && missing != -1) break;
        }
        return {repeating, missing};
        
    }
};