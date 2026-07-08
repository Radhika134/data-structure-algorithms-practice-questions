class Solution {
public:
    int totalWeight(vector<int> & weights,int n)
    {
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum+=weights[i];
        }
        return sum;
    }

    int isPossible(vector<int>& weights,int mid, int n)
    {
        int ansDays = 1,load=0;
        for(int i=0;i<n;i++)
        {
            if(load+weights[i] > mid)
            {
                ansDays++;
                load=weights[i];
            }
            else
            {
                load+=weights[i];
            }
        }
       
        return ansDays;

    }

    int shipWithinDays(vector<int>& weights, int days) {
        int n = weights.size();

        int low = *max_element(weights.begin(), weights.end());
        int high = totalWeight(weights,n);
        int ans = -1;
        while(low<=high)
        {
            int mid = low+((high-low)/2);
            int currDays = isPossible(weights,mid,n);

            if(currDays <= days)
            {
                ans=mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
        
    }
};