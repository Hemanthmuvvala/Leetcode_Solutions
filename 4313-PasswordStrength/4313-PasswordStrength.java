// Last updated: 7/12/2026, 11:11:01 PM
class Solution {
    public int passwordStrength(String password) {
        String s=password;
        HashSet<Character> seen=new HashSet<>();
        int total=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(!seen.contains(ch)){
                seen.add(ch);
                if(ch>= 'a' && ch<='z'){
                    total+=1;
                }else if(ch>='A' && ch<='Z'){
                    total+=2;
                }
                else if(ch>='0' && ch<='9'){
                    total+=3;
                }else if(ch>='!' || ch=='@' || ch=='#'){
                    total+=5;
                }
            }
        }

        return total;
    }
}