class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        boolean[] freq = new boolean[nums.length];

        solve(nums, new ArrayList<>(), ans, freq);

        return ans;
    }

    void solve(int[] nums, List<Integer> curr,
               List<List<Integer>> ans, boolean[] freq) {

        if(curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {

            if(!freq[i]) {

                curr.add(nums[i]);
                freq[i] = true;

                solve(nums, curr, ans, freq);

                curr.remove(curr.size() - 1);
                freq[i] = false;
            }
        }
    }
}