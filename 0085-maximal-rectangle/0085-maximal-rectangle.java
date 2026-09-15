class Solution {

    public int[][] prefixSum(char[][] matrix)
    {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] pSum = new int[r][c];
       

        for(int j = 0;j<c;j++)
        {
            int sum = 0;
            for(int i = 0;i<r; i++)
            {
                sum += (matrix[i][j]-'0');
                if(matrix[i][j] == '0')
                {
                    sum = 0;
                }

                pSum[i][j] = sum;
            }
        }
        return pSum;
    }

    public int histogramRect(int[] arr)
    {
        Stack<Integer> stk = new Stack<>();

        int n = arr.length, area = 0;
        for(int i = 0; i < n; i++)
        {
            while(!stk.isEmpty() && arr[stk.peek()] > arr[i])
            {
                int element = stk.pop();
                int nse = i;
                int pse = (stk.isEmpty()) ? -1 : stk.peek();

                area = Math.max(area, arr[element] * (nse - pse - 1));

         
            }
            
            stk.push(i);
        }
        while(!stk.isEmpty())
        {
            int element = stk.pop();
            int nse = n;
            int pse = (stk.isEmpty()) ? -1 : stk.peek();

            area = Math.max(area, arr[element] * (nse - pse - 1));

        }
        return area;
    }

    public int maximalRectangle(char[][] matrix) {
        int[][] pSum = prefixSum(matrix); 
        int maxArea = 0;

        for(int i = 0;i<matrix.length; i++)
        {
            maxArea = Math.max(maxArea, histogramRect(pSum[i]));
        }

        return maxArea;
    }
}