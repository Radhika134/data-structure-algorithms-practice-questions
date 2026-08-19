class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> mpp = new HashMap<>();

        for (char ch : s.toCharArray()) {
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(
                (a, b) -> mpp.get(b) - mpp.get(a));
        for (char ch : mpp.keySet()) {
            pq.add(ch);
        }
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()) {
            char ch = pq.poll();
            int freq = mpp.get(ch);

            while(freq > 0)
            {
                ans.append(ch);
                freq--;
            }
            
        }

        return ans.toString();

    }
}