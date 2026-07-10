class Solution {
    public String reverseWords(String s) {
        // String[] words = s.split("\\s+");
        // StringBuilder sb = new StringBuilder();

        // for (int i = words.length - 1; i >= 0; i--) 
        // {
        //     sb.append(words[i]);
        //     sb.append(" ");
        // }
        // return sb.toString().trim();


        String[] words = s.split("\\s+");
        int i=0;
        int j=words.length-1;

        while(i<j)
        {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;

            i++;
            j--;
        }

        StringBuilder sb = new StringBuilder();
        for(String word : words)
        {
            sb.append(word).append(" ");
        }

        return sb.toString().trim();


    }
}