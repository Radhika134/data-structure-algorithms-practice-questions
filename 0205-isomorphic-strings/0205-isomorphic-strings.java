class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character, Character> mpp1 = new HashMap<>();
        HashMap<Character, Character> mpp2;

        if (s.length() != t.length()) return false;

        mpp2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (mpp1.containsKey(s.charAt(i))) {
                if (mpp1.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                mpp1.put(s.charAt(i), t.charAt(i));
            }

            if (mpp2.containsKey(t.charAt(i))) {
                if (mpp2.get(t.charAt(i)) != s.charAt(i))
                    return false;
            } else {
                mpp2.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;
    }
}