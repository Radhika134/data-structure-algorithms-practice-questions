class Solution {

    public int[] findNSE(int[] heights)
    {
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[heights.length];
        int n = heights.length;

        for(int i = n-1; i >= 0; i--)
        {
            while(!stk.isEmpty() && heights[stk.peek()] > heights[i])
            {
                stk.pop();
            }
            if(stk.isEmpty()) res[i] = n;
            else
            {
                res[i] = stk.peek();
            }

            stk.push(i);
        }
        return res;
    }

    public int[] findPSE(int[] heights)
    {
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[heights.length];
        int n = heights.length;

        for(int i = 0; i < n; i++)
        {
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i])  //remember this >=
            {
                stk.pop();
            }
            if(stk.isEmpty()) res[i] = -1;
            else
            {
                res[i] = stk.peek();
            }

            stk.push(i);
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        int[] nse = findNSE(heights);
        int[] pse = findPSE(heights);

        for(int i = 0;i<n;i++)
        {
            maxArea = Math.max( maxArea, heights[i] * (nse[i] - pse[i] - 1));
        }
        return maxArea;
    }
}