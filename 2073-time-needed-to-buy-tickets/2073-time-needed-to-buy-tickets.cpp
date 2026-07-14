class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
       int num = 0;
       while(true)
       {
        for(int i=0;i<tickets.size();i++)
        {
            if(tickets[i] != 0)
            {
                tickets[i] = tickets[i] - 1;
                num++;

                if(i == k && tickets[k] == 0)
                {
                    return num;
                }
            }
        }
       }
    }
};