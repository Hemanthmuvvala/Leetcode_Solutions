// Last updated: 7/13/2026, 12:11:50 AM
class Solution {
    public int numberOfSubstrings(String s) {
        int lastSeen[]=new int[3];
        Arrays.fill(lastSeen,-1);
        int n=s.length();
        int count=0;

        for(int i=0;i<n;i++){
            lastSeen[s.charAt(i)-'a']=i;
            int maxPos=Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2]));
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                count = count +1+maxPos;
            }
        }

        return count;
    }
}