// Last updated: 7/12/2026, 11:11:39 PM
class Solution {
    public String reverseWords(String s) {
        String [] words = s.split(" ");
        int count=0;
        int k=vCount(words[0]);
        for (int i = 1; i < words.length; i++) {
            if(vCount(words[i])==k)
                words[i]=reverse(words[i]);
        }

        return String.join(" ",words);
    }

    public static int vCount(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'
                    || ch == 'u') {
                count++;
            }

        }
        return count;
    }
    public static String reverse(String s){
       StringBuilder sb=new StringBuilder(s);

        return sb.reverse().toString();
    }
}