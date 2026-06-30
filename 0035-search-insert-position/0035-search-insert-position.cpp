class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int n = nums.size();
        int low = 0, high = n - 1;
        int mini = n;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] >= target) {
                high = mid - 1;
                mini = mid;
            } else if (nums[mid] < target)
                low = mid + 1;
        }
        return mini;
    }
};
