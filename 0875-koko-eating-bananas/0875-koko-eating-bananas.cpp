class Solution {
public:
    int findMax(vector<int> &piles,int n)
    {
        int maxi = INT_MIN;
        for(int i=0;i<n;i++)
        {
            maxi = max(maxi, piles[i]);
        }
        return maxi;
    }

    long long timeTaken(vector<int>& piles, int k) {
        long long totalHrs = 0;
        for (int i = 0; i < piles.size(); i++) {
            totalHrs += ceil((double)piles[i] / (double)k);
        }
        return totalHrs;
    }

    int minEatingSpeed(vector<int>& piles, int h) {
        int n = piles.size();
        int ans = -1;

        int high = findMax(piles,n), low = 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            long long hrs = timeTaken(piles,mid);
            if (hrs<=h)
            {
                ans = mid;
                high = mid-1;
            } 
            else if (hrs > h) 
            {
                low = mid + 1;
            }
          
        }
        return ans;
    }
};