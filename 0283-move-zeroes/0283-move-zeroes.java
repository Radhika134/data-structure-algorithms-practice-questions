class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        int count = 0;
        int k = 0;
        for(int i=0;i<n;i++)
        {
            if(nums[i] == 0)
            { 
                count++;
                
            }
            else
            {
                nums[k] = nums[i];
                k++;
            }
        }
        while(count>0)
        {
            nums[k] = 0;
            k++;
            count--;
        }

        
    }
}