class Solution {
public:
    int minDays(vector<int>& bloomDay, int n) {
        int mini = INT_MAX;
        for (int i = 0; i < n; i++) {
            mini = min(mini, bloomDay[i]);
        }
        return mini;
    }

    int maxDays(vector<int>& bloomDay, int n) {
        int maxi = INT_MIN;
        for (int i = 0; i < n; i++) {
            maxi = max(maxi, bloomDay[i]);
        }
        return maxi;
    }

    int isPossible(vector<int>& bloomDay, int n, int k, int mid) {
        int count = 0, noBouquets = 0;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= mid) {
                count++;
            } else {
                noBouquets += count / k;
                count = 0;
            }
        }
        noBouquets += count / k;
        return noBouquets;
    }

    int minDays(vector<int>& bloomDay, int m, int k) {
        int n = bloomDay.size();
        long long val = (long long)m * (long long)k;

        int low = minDays(bloomDay, n);
        int high = maxDays(bloomDay, n);
        int ans = -1;

        if (n < val)
            return -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            int currBouquets = isPossible(bloomDay, n, k, mid) ;
            if (currBouquets >= m) {
                ans = mid;
                high = mid-1;
            }
            else if (currBouquets < m) low = mid + 1;
           
        }
        return ans;
    }
    
};