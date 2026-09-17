class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n; i++)
        {
            //koi element agar k window sw bahar ka h toh remove krdo
            while(!dq.isEmpty() && dq.peekFirst() <= i-k)
            {
                dq.pollFirst();
            }

            // jb tk samller elemnts h deque ke last se remove krte rho
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()])
            {
                dq.pollLast();
            }
            
            //add current ele index
            dq.offerLast(i);
           
            //pehli window bnte hi list mei daldo;
            if(i >= k - 1)
            {
                arr.add(nums[dq.peekFirst()]);
            }


        }

        int[] res = new int[arr.size()];
        for(int i = 0; i<res.length; i++)
        {
            res[i] = arr.get(i);
        }
        return res;
        
    }
}