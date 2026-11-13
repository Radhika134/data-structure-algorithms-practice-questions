class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long both = Math.min(need1, need2);
        return both * Math.min(cost1 + cost2, costBoth)  // pair or bundle
             + (need1 - both) * Math.min(cost1, costBoth)  // single or bundle
             + (need2 - both) * Math.min(cost2, costBoth);
    }
}