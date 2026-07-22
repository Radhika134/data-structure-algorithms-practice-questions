class Solution {
    public boolean isVowel(char ch)
    {
        return (ch == 'a' || ch == 'e' || ch =='i'||ch=='o'||ch=='u'
               ||ch=='A'||ch=='E'||ch=='I'||ch=='O' ||ch=='U');
    }
    public String reverseVowels(String s) {
        // Write your code here
        int n = s.length();
        char[] arr = s.toCharArray();
        int i=0,j=n-1;
        
        while(i<j)
        {
            while(i<j && !isVowel(arr[i]))  i++;
            while(i<j && !isVowel(arr[j]))  j--;
            
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            i++;
            j--;
        }
        return new String(arr);
    }
}