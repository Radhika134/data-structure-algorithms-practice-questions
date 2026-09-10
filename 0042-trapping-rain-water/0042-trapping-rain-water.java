class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int start = 0, end = n-1;
        int water = 0;
        int leftMax = 0, rightMax = 0;

        while(start < end)
        {
            leftMax = Math.max(leftMax, height[start]);
            rightMax = Math.max(rightMax, height[end]);

            if(leftMax < rightMax)
            {
                water += leftMax - height[start];
                start++;
            }
            else
            {
                water += rightMax - height[end];
                end--;
            }

        }
        return water;
    }
}