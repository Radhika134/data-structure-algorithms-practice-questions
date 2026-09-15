class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i<n; i++)
        {
            while(!stk.isEmpty() && heights[stk.peek()] > heights[i])
            {
                int element = stk.pop();
                int nse = i;
                int pse = (stk.isEmpty())? -1: stk.peek();

                int area = heights[element] * (nse - pse - 1);
                maxArea = Math.max(maxArea, area);
            }
            stk.push(i);

        }

        while(!stk.isEmpty())
        {
            int nse = n;
            int element = stk.pop();
            int pse = (stk.isEmpty())? -1: stk.peek();

            int area = heights[element] * (nse - pse - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}