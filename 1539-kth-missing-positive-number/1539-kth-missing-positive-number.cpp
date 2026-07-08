class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        int n = arr.size();

        int i=0;
        int missingCount=0;
        int num = 1;

        while(true)
        {
            if(i<n && arr[i] == num)
            {
                //number mil gya
                i++;
            }
            else
            {
                //number nhi mila
                missingCount++;
                if(missingCount == k)
                {
                    return num;
                }
            }
            num++;
        }
        return -1;
    }
};