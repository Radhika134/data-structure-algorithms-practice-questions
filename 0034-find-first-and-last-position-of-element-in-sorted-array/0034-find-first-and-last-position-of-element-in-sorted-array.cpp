class Solution {
public:
int firstOcc(vector<int> & nums,int target, int n)
{
    int low = 0;
    int high = n-1;
    int start = -1;
    while(low<=high)
    {
        int mid = low+((high-low)/2);
        if(nums[mid] == target)
        {
            start = mid;
            high = mid-1;

        }
        else if(nums[mid]>target)
        {
            high = mid-1;

        }
        else low = mid+1;
    }
    return start;
}

int lastOcc(vector<int> & nums,int target, int n)
{
    int low = 0;
    int high = n-1;
    int end = -1;
    while(low<=high)
    {
        int mid = low+((high-low)/2);
        if(nums[mid] == target)
        {
            end = mid;
            low = mid+1;

        }
        else if(nums[mid]>target)
        {
            high = mid-1;

        }
        else low = mid+1;
    }
    return end;
}

    vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size();
        int first = firstOcc(nums,target,n);
        if(first == -1)
        {
            return {-1,-1};
        }
        int last = lastOcc(nums,target,n);
        return{first,last};
        
    }
};