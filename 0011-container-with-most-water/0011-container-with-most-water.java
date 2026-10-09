class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int left = 0, right = n -1;
        int maxArea = Integer.MIN_VALUE;

        while(left < right)
        {
            int area = Math.min(height[left], height[right]) * (right - left);

            if(maxArea < area)
            {
                maxArea = area;
            }

            if(height[left] < height[right])
            {
                left++;
            }
            else right--;

        }

        return maxArea;
    }
}